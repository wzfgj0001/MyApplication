package servicetest.zkk.com.myapplication.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:<br>
 * <p/>
 * date: 2017/3/3.
 *
 * @author GuJian
 */
public class BindTestService extends Service{
    /*todo CopyONWriteArrayList 进行自动的线程同步*/
    private CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
//    private List<Book> books = new ArrayList<>();
    /*TODO REMOTECALLBACKLIST的理解*/
    private RemoteCallbackList<BookListener> listeners = new RemoteCallbackList<>();
    private BookManager.Stub stub = new BookManager.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            Logger.v("服务端：addBookName:" + book.getName());
//            SystemClock.sleep(5000);
            books.add(book);
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            Logger.v("服务端：getBookList:"+books.size());
            SystemClock.sleep(5000);
            return books;
        }

        @Override
        public void addListener(BookListener listener) throws RemoteException {
//            if(!listeners.contains(listener)) {
                listeners.register(listener);
//                Logger.v("服务端：addListenerSize" + listeners.size());
//            }else{
//                Logger.v("服务端：addListenerSize已存在" );
//            }
        }

        @Override
        public void deleteListener(BookListener listener) throws RemoteException {
//            if(listeners.contains(listener)){
                listeners.unregister(listener);
//                Logger.v("服务端：removeListenerSize"+listeners.size());
//            }else{
//                Logger.v("服务端：removeListenerSize没有找到");
//            }
//            Logger.v("服务端：deletListnerSize" + listeners.size());
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book(1,"bookOne");
        books.add(book);
        book = new Book(2,"bookTwo");
        books.add(book);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(5000);
                        int i = books.size();
                        Book book = new Book(i+1,"book"+(i+1));
                        onNewBookArrive(book);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     *服务器添加新书
     * @param book
     */
    public void onNewBookArrive(Book book){
        Logger.v("服务端添加书：" + book.getName());
        books.add(book);
        final int N = listeners.beginBroadcast();
        for(int i=0;i<N;i++){
            BookListener bookListener = listeners.getBroadcastItem(i);
            if(bookListener!=null){
                try {
                    bookListener.retreview(book);
                }catch ( Exception e){
                    e.printStackTrace();
                }
            }
        }
        listeners.finishBroadcast();
    }
}

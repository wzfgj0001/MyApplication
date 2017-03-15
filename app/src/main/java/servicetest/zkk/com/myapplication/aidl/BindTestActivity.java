package servicetest.zkk.com.myapplication.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import servicetest.zkk.com.myapplication.Logger;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:的撒旦撒洒洒洒洒dwdwe大<br>
 * <p/>
 * date: 2017/3/3.
 *
 * @author GuJian
 */
public class BindTestActivity extends Activity implements View.OnClickListener{
    private Button bindBtn;
    private Button addBtn;
    private Button getBtn;
    private Button testBtn;
    private TextView mTextView;
    private BookManager bookManager;
    private static  final  int MESSAGE_ARRVIE =1;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_ARRVIE:
                    Book book = (Book) msg.obj;
                    mTextView.setText("服务端通知添加了一本书"+book.getName());
                    break;
            }
            return false;
        }
    });
    private BookListener bookListener = new BookListener.Stub() {
        @Override
        public void retreview(Book book) throws RemoteException {
            Logger.v("服务端通知添加了一本书" + book.getName());
//            mTextView.setText("服务端通知添加了一本书" + book.getName());
//            handler.sendMessage()
            handler.obtainMessage(MESSAGE_ARRVIE,book).sendToTarget();

        }
    };
    private int i = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bind);
        bindBtn = (Button) findViewById(R.id.bindBtn);
        addBtn = (Button) findViewById(R.id.addBtn);
        getBtn = (Button) findViewById(R.id.getBtn);
        mTextView = (TextView) findViewById(R.id.text_tv);


        bindBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookManager = BookManager.Stub.asInterface(service);
            try {
                bookManager.addListener(bookListener);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.bindBtn:
                Intent intent = new Intent(this,BindTestService.class);
                bindService(intent,
                        connection,BIND_AUTO_CREATE);
                break;
            case R.id.addBtn:
                try {
                    int i = bookManager.getBookList().size();
                    Book book = new Book(i+1, "book" + (i+1));
                    Logger.v("客户端：addBookName:" + book.getName());
                    bookManager.addBook(book);
                   // i++;
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.getBtn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            List<Book> bookList = bookManager.getBookList();
                            if(bookList!=null&&bookList.size()>0){
                                for(Book book:bookList) {
                                    Logger.v("客户端:booklist:" + book.getName());
                                }
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            bookManager.deleteListener(bookListener);
        }catch (Exception e){
            e.printStackTrace();
        }
        unbindService(connection);
    }
}

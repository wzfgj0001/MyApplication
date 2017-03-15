// BookManager.aidl
package servicetest.zkk.com.myapplication.aidl;

// Declare any non-default types here with import statements
import servicetest.zkk.com.myapplication.aidl.Book;
import servicetest.zkk.com.myapplication.aidl.BookListener;
interface BookManager {
    void  addBook(in Book book);
    List<Book> getBookList();
    void addListener(BookListener listener);
    void deleteListener(BookListener listener);
}

// BookListener.aidl
package servicetest.zkk.com.myapplication.aidl;

// Declare any non-default types here with import statements
import servicetest.zkk.com.myapplication.aidl.Book;
interface BookListener {
    void retreview(in Book book);
}

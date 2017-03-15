package servicetest.zkk.com.myapplication.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Function:<br>
 * <p/>
 * date: 2017/3/3.
 *
 * @author GuJian
 */
public class Book implements Parcelable{
    public int id;
    public String name;

    public Book(int id,String name){
        this.id = id;
        this.name = name;
    }
    protected Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(name);
    }

}

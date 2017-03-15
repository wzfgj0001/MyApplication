package servicetest.zkk.com.myapplication.IpcExa;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Function:parcelale实现序列化和反序列<br>
 * <p/>
 * date: 2017/3/1.
 *
 * @author GuJian
 */
public class User implements Parcelable{
    private  int userId;
    private String userName;
    private boolean isMale;
    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readInt() == 1;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeInt(isMale?1:0);
    }
}

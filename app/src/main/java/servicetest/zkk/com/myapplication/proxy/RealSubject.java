package servicetest.zkk.com.myapplication.proxy;

/**
 * Function:委托类<br>
 * <p/>
 * date: 2017/8/2.
 *
 * @author GuJian
 */
public class RealSubject implements Account{
    @Override
    public void queryAccount() {
        System.out.println("query account");
    }
}

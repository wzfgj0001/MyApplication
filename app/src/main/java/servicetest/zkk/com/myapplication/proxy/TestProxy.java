package servicetest.zkk.com.myapplication.proxy;

/**
 * Function:<br>
 * <p/>
 * date: 2017/8/2.
 *
 * @author GuJian
 */
public class TestProxy {
    public  static void  main(String args[]){
        ProxySubject proxySubject = new ProxySubject();
        Account account = (Account) proxySubject.getProxy(new RealSubject());
        account.queryAccount();
    }
}

package servicetest.zkk.com.myapplication.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Function:动态代理类<br>
 * <p/>
 * date: 2017/8/2.
 *
 * @author GuJian
 */
public class ProxySubject implements InvocationHandler{
    Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before");
        result = method.invoke(target,args);
        System.out.println("after");
        return result;
    }

    public  Object getProxy(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}

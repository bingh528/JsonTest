package us.bingh.proxy.dynamicproxy;

import sun.misc.ProxyGenerator;
import us.bingh.proxy.staticproxy.Buy;
import us.bingh.proxy.staticproxy.User;
import us.bingh.proxy.staticproxy.UserProxy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Buy buy;

    public DynamicProxy(Buy buy) {
        this.buy = buy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("buyHouse")) {
            long money = (long) args[0];
            long newMoney = (long) (money * 0.9);
            System.out.println("中介费 " + (money - newMoney) + " 钱 ");
            args[0] = newMoney;
            return method.invoke(buy, args);
        }
        return null;
    }

    public static void main(String[] args) {
        Buy buy = new User();
        UserProxy proxy = new UserProxy();
        proxy.setProxy(buy);
        proxy.buyHouse(10000);


        System.out.println("动态代理测试");

        Buy dynamicBuy = (Buy) Proxy.newProxyInstance(buy.getClass().getClassLoader(), buy.getClass().getInterfaces(), new DynamicProxy(buy));
        dynamicBuy.buyHouse(10000);
        createProxyClassFile();

    }

    public static void createProxyClassFile() {
        String name = "ProxyClass";
        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{Buy.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(name + ".class");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

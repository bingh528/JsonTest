package us.bingh.threadlocal;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalTest {

    private static ThreadLocal<Integer> integerThreadLocal = new InheritableThreadLocal<Integer>(){
        @Override
        protected Integer childValue(Integer parentValue) {
            return 111;
        }
    };


    public static void main(String args[]) throws InterruptedException {
        integerThreadLocal.set(123);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread int = " + integerThreadLocal.get());
            }
        },"thread 1").start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("main int =" + integerThreadLocal.get());
    }
}

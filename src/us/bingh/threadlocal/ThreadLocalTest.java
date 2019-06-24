package us.bingh.threadlocal;

/**
 * threadlocal不能实现单例，网上大多是错误的，threadlocal使用场景是，每个线程拥有独立的实例，并且需要在多个方法共享该实例
 */
public class ThreadLocalTest {


    private ThreadLocalTest() {

    }

    private String testStr = "initStr";

    private static final ThreadLocal<ThreadLocalTest> local = new ThreadLocal<ThreadLocalTest>() {
        @Override
        protected ThreadLocalTest initialValue() {
            return new ThreadLocalTest();
        }
    };

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public static ThreadLocalTest getInstance() {
        return local.get();
    }


    public static void main(String[] args) {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
                String testStr = getInstance().getTestStr();
                System.out.println(testStr);
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String testStr = getInstance().getTestStr();
                System.out.println(testStr);
                getInstance().setTestStr("thread1");
                testStr = getInstance().getTestStr();
                System.out.println(testStr);
                thread2.start();

            }
        });

        thread1.start();


    }

}

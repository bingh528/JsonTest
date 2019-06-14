package us.bingh.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    static class MainActivity {

        private volatile int count = 0;
        private volatile boolean isStucked = false;
        Object object0 = new Object();
        Object object1 = new Object();


        void run() {
            System.out.println("main thread start------");
            while (true) {
                if (isStucked) {

                } else {
                    count++;
                    System.out.println("count++");
                    isStucked = true;
                }


//                while (true){
//                    try {
//
////                    MainActivity.this.wait(2000);
//                        System.out.println("main thread sleeping------");
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("main thread running------");
//                }


            }


        }

        void runSubThread() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("sub thread sleeping------");

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isStucked = false;
                        System.out.println("sub thread running------");

                    }


                }
            }).start();


        }

    }

    public static void main(String[] args) {
//        MainActivity test = new MainActivity();
//        test.runSubThread();
//        test.run();


//        SortUtils sortUtils = new SortUtils();
//        sortUtils.buddleSort(new int[10]);


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("thread start");
//            }
//        });
//        thread.start();
//
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println("thread ="+(thread==null));
//        List<String> list1 = new ArrayList<String>();
//        list1.add("sss");
//        List<String> list2 = new ArrayList<String>();
//        list2.add("rrr");
//        unsafe(list1,list2);
//        Thread[] threads = new Thread[THREAD_NUM];
//        CountDownLatch latch = new CountDownLatch(THREAD_NUM);
//        for (Thread thread : threads) {
//
//            thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 20000; i++) {
//                        increase();
//                    }
//                    latch.countDown();
//                }
//            });
//            thread.start();
//        }
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(count);

        boolean flag = false;
        Object object = null;
        flag &= object == null;
        System.out.print(flag);

    }

    public static volatile AtomicInteger count = new AtomicInteger(0);
    private static final int THREAD_NUM = 10;

    public static void increase() {
        count.incrementAndGet();
    }


    static void unsafe(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> integerList = Arrays.asList(42);
        array[0] = integerList; // 语义不对，不过编译器不会有警告

        String s = stringLists[0].get(0); // 运行时抛出 ClassCastException
    }


}

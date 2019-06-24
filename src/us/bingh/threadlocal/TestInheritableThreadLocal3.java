package us.bingh.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestInheritableThreadLocal3 {

    private static final ThreadLocal<Map<Object, Object>> testThreadLocal = new InheritableThreadLocal<Map<Object, Object>>();
    private static final ThreadLocal<Map<Object, Object>> threadLocal = new InheritableThreadLocalMap<Map<Object, Object>>();

    public static void main(String args[]) throws InterruptedException {

        // 下面的测试1在上文已经做过(上文的测试2), 此处拿出来是为了进行比较
        // 测试1: 可变对象, 父线程初始化, 子线程先获取对象再修改对象值
        // 结论1: 子线程可以通过先获取对象再修改的方式影响父线程的对象值 
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", 123);
        testThreadLocal.set(map);   // 父线程进行初始化

        Thread testThreadone = new TestThread();   // 创建子线程
        testThreadone.start();
        TimeUnit.MILLISECONDS.sleep(100);   // 父线程睡眠, 以等待子线程执行完毕
        System.out.println("main = " + testThreadLocal.get());  // 此处输出为子线程的值, 说明子线程影响父线程的对象值
        System.out.println();

        // 测试2: 可变对象, 父线程初始化, 子线程先获取对象再修改对象值
        // 结论2: 通过重写childValue()实现子线程与父线程的互不影响
        Map<Object, Object> mapTo = new HashMap<>();
        mapTo.put("aa", 123);
        threadLocal.set(mapTo);   // 父线程进行初始化

        Thread testThread = new TestThreadTo();   // 创建子线程
        testThread.start();
        TimeUnit.MILLISECONDS.sleep(100);   // 父线程睡眠, 以等待子线程执行完毕 
        System.out.println("main = " + threadLocal.get());  // 此处输出为父线程的值, 说明子线程与父线程已经互不影响

    }

    private static class TestThread extends Thread {
        @Override
        public void run() {
            // 此处输出父线程的初始化对象值, 代表子线程确实继承了父线程的对象值
            System.out.println("TestThread.before = " + testThreadLocal.get());
            // 子类拿到对象并修改
            testThreadLocal.get().put("aa", 456);
            System.out.println("testThreadLocal = " + testThreadLocal.get());
        }
    }

    private static class TestThreadTo extends Thread {
        @Override
        public void run() {
            // 此处输出父线程的初始化对象值, 代表子线程确实继承了父线程的对象值
            System.out.println("TestThreadTo.before = " + threadLocal.get());
            // 子类拿到对象并修改
            threadLocal.get().put("aa", 456);
            System.out.println("threadLocal = " + threadLocal.get());
        }
    }

    private static final class InheritableThreadLocalMap<T extends Map<Object, Object>>
            extends InheritableThreadLocal<Map<Object, Object>> {
        // 重写ThreadLocal中的方法
        protected Map<Object, Object> initialValue() {
            return new HashMap<Object, Object>();
        }

        // 重写InheritableThreadLocal中的方法
        protected Map<Object, Object> childValue(Map<Object, Object> parentValue) {
            if (parentValue != null) {
                // 返回深拷贝, 以达到使子线程无法影响主线程的目的
                return (Map<Object, Object>) ((HashMap<Object, Object>) parentValue).clone();
            } else {
                return null;
            }
        }
    }

}
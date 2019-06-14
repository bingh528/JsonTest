package us.bingh.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.count();
        counter.count();

        try {
            Class<?> aClass = Class.forName("us.bingh.reflect.Counter");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            try {
                Field field = aClass.getDeclaredField("count");
                try {
                    field.setAccessible(true);
                    field.set(counter, 1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            System.out.println("meethod[]=" + declaredMethods);

            try {
                declaredMethods[0].invoke(counter);
                declaredMethods[0].invoke(counter);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

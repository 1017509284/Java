package com.zhaomeng.Singlethon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: zhaomeng
 * @Date: 2022/10/10 23:50
 */
// !懒汉式单例
public class Lazy {

    private static boolean screet = false;
    private Lazy() {
        synchronized (Lazy.class) {
            if (screet == false) {
                screet = true;
            } else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
    }

    // !为了防止指令重排，加上volatile关键字
    private volatile static Lazy lazy;

    // !当线程a进入new Lazy阶段，突然线程b进入，此时a线程还没有new结束，b线程可以进入第一个if，
    // !由于锁在线程a那里，b线程只能等待，等a new完了后释放锁，b线程拿到锁后，发现lazy已经不是null了，所以无法二次new
    // !double check:第一个if，除第一个线程，若其他所有来访的线程访问时，当第一个线程还没有new结束，那么其他所有线程等待锁的释放，
    // !第二个if，当第一个线程new完了之后，其他线程进入第二个if，发现此时new 结束了，因此lazy也就不是null了，第二个if其他线程根本进不去
    // !双重检测锁模式 DCL懒汉式
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    // !1.分配内存空间
                    // !2.执行构造方法，初始化对象
                    // !3.把这个对象指向这个空间
                    lazy = new Lazy();
                }
            }
        }

        return lazy;
    }

    // !可以通过反射，拿到构造器，来进行new instance，这两个instance是不一样的
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Lazy instance = Lazy.getInstance();
        // !拿到Lazy的Class对象，根据Class对象拿到默认构造器
        Constructor<Lazy> constructor= Lazy.class.getDeclaredConstructor(null);
        // !无视private私有属性
        constructor.setAccessible(true);
        Lazy instance1 = constructor.newInstance();
        Lazy instance2 = constructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance2);
    }
}

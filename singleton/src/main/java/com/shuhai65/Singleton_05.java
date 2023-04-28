package com.shuhai65;

/**
 * 双检锁懒汉式
 * 双检锁的⽅式是⽅法级锁Singleton_02的优化，减少了部分获取实例的耗时。
 * <p>
 * 为何必须加 volatile：
 * <p>
 * `INSTANCE = new Singleton4()` 不是原子的，分成 3 步：创建对象、调用构造、给静态变量赋值，其中后两步可能被指令重排序优化，变成先赋值、再调用构造
 * 如果线程1 先执行了赋值，线程2 执行到第一个 `INSTANCE == null` 时发现 INSTANCE 已经不为 null，此时就会返回一个未完全构造的对象
 */
public class Singleton_05 {

    private static volatile Singleton_05 instance;

    private Singleton_05() {
    }

    public static Singleton_05 getInstance() {
        if (null != instance) return instance;
        synchronized (Singleton_05.class) {
            if (null == instance) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }

}

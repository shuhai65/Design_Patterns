package com.shuhai65;

/**
 * 懒汉模式(线程安全)
 * 此种模式虽然是安全的，但由于把锁加到⽅法上后，所有的访问都因需要锁占⽤导致资源的浪费。
 * 如果不是特殊情况下，不建议此种⽅式实现单例模式。
 * 其实只有首次创建单例对象时才需要同步，但该代码实际上每次调用都会同步
 * 只需要首次创建时同步就行，可以参考双检锁Singleton_05
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (null != instance) return instance;
        return new Singleton_02();
    }

}

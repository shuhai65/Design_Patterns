package com.shuhai65;

/**
 * 饿汉模式(线程安全)
 * <p>
 * <p>
 * 此种⽅式与我们开头的第⼀个实例化 Map 基本⼀致，在程序启动的时候直接运⾏加载，后续有外
 * 部需要使⽤的时候获取即可。
 * 但此种⽅式并不是懒加载，也就是说⽆论你程序中是否⽤到这样的类都会在程序启动之初进⾏创
 * 建。
 * 那么这种⽅式导致的问题就像你下载个游戏软件，可能你游戏地图还没有打开呢，但是程序已经将
 * 这些地图全部实例化。到你⼿机上最明显体验就⼀开游戏内存满了，⼿机卡了，需要换了。
 */
public class Singleton_03 {

    private static final Singleton_03 INSTANCE = new Singleton_03();

    private Singleton_03() {
        //构造方法抛出异常是防止反射破坏单例
        if (INSTANCE != null) {
            throw new RuntimeException("单例对象不能重复创建");
        }
        System.out.println("private Singleton_03()");
    }

    public static Singleton_03 getInstance() {
        return INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("otherMethod()");
    }

    //`readResolve()` 是防止反序列化破坏单例
    public Object readResolve() {
        return INSTANCE;
    }
}

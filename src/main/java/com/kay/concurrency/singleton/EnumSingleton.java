package com.kay.concurrency.singleton;

import com.kay.concurrency.annotations.Recommend;
import com.kay.concurrency.annotations.ThreadSafe;

/**
 * Created by kay on 2018/5/28.
 * <p>
 * 使用枚举获取单例
 */
@ThreadSafe
@Recommend
public class EnumSingleton {

    private EnumSingleton() {

    }

    public static EnumSingleton getSingleton() {
        return SingletonHolder.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.getSingleton());
        System.out.println(EnumSingleton.getSingleton());

    }

    private enum SingletonHolder {
        INSTANCE;

        private EnumSingleton singleton = null;

        //JVM保证该方法只被执行一次
        SingletonHolder() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }
}

package com.steady.d4_abstract.test_door;

/**
 * 定义一个p门
 * 拥有门的基本属性以及响铃
 */
public class P_door extends Door implements Alarm{


    public P_door(int height, int weight, String name) {
        super(height, weight, name);
    }

    @Override
    public void open() {
        System.out.println("P_open");
    }

    @Override
    public void close() {
        System.out.println("P_close");
    }

    @Override
    public void alarm() {
        System.out.println("P_alarm");
    }
}

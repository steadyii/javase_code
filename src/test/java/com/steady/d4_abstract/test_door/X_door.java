package com.steady.d4_abstract.test_door;
/**
 * 定义x门,拥有人脸识别功能
 */
public class X_door extends Door implements Face_rec{

    public X_door(int height, int weight, String name) {
        super(height, weight, name);
    }

    @Override
    public void open() {
        System.out.println("X_open");
    }

    @Override
    public void close() {
        System.out.println("X_close");
    }

    @Override
    public void rec() {
        System.out.println("X_rec");
    }
}

package com.steady.d13_juc.d4;

public class Thread07yield extends Thread{
    public Thread07yield(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i == 30) {
                System.out.println(Thread.currentThread().getName() + ",释放 cpu 执行权");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }
    public static void main(String[] args) {
        Thread07yield mayikt01 = new Thread07yield("mayikt01");
        Thread07yield mayikt02 = new Thread07yield("mayikt02");
        mayikt01.start();
        mayikt02.start();
    }
}

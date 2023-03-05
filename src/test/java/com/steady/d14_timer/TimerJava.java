package com.steady.d14_timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 在定时器中使用时间任务
 */
public class TimerJava {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000);
    }
}

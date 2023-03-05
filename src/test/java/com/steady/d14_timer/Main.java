package com.steady.d14_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        System.out.println(new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Main-run");
            }
        },3000,1000);
        
        Thread.sleep(6000);
        timer.cancel();
    }
}

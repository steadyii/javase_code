package com.steady.d14_timer;

/**
 * 子级封装时间任务
 */
public class TimerTest {

    public static void main(String[] args) {
        new TimerTask(() -> System.out.println("dingshi"), 3000).start();
    }
    static class TimerTask {
        Runnable task;
        long time;
        public TimerTask(Runnable task, long time) {
            this.task = task;
            this.time = time;
        }
        public void start() {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}

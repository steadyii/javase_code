package com.steady.d13_juc.d4;

public class Test01notify {
    private final Object objectLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Test01notify().print();
    }

    public void print() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + ">1<");
                /*
                          this.wait();释放锁资源 同时当前线程会阻塞等待
                           this.wait()、notify 需要放到synchronized同步代码中使用
                 */
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ">2<");
            }
        }).start();

        try {
            Thread.sleep(3000);
            // 主线程3s 之后唤醒该子线程
            synchronized (objectLock) {
                objectLock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

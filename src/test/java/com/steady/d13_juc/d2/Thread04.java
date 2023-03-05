package com.steady.d13_juc.d2;

public class Thread04 {
    
    static class Res {
        public String userName;
        public char sex;
        public boolean flag = false;
    }

    static class InputThread extends Thread {
        private final Res res;
        public InputThread(Res res) {
            this.res = res;
        }
        
        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (res) {
                    if (res.flag) {      //如果 flag = true 等待,同时释放锁
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        res.userName = "余胜军";
                        res.sex = '男';
                    } else {
                        res.userName = "小薇";
                        res.sex = '女';
                    }
                    res.flag = true;
                    res.notify();
                }
                // 1%2 = 2%2  3%2 4%2=
                count = (count + 1) % 2;
            }
        }
    }

    static class OutPutThread extends Thread {
        private final Res res;
        public OutPutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    if (!res.flag) {
                        // 如果 res.flag=false 则 输出的线程 主动释放锁
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(res.userName + "," + res.sex);
                    // 输出完毕 交给我们的输入线程继续的输入
                    res.flag = false;
                    res.notify();;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread04().print();
    }

    public void print() {
        Res res = new Res();

        InputThread inputThread = new InputThread(res);
        OutPutThread outPutThread = new OutPutThread(res);
        inputThread.start();
        outPutThread.start();
    }
}

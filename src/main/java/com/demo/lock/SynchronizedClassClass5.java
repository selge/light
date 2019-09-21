package com.demo.lock;

/**
 * 类锁的第二种形式，*.class形式
 *
 * @author xiaol
 * @date 2019/9/20
 */
public class SynchronizedClassClass5 implements Runnable {

    private static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    private static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (Object.class) {
            System.out.println("我是类锁的第二种形式：synchronized(*.class)形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}

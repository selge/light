package com.demo.lock;

/**
 * 类锁的第一种形式，static形式
 *
 * @author xiaol
 * @date 2019/9/20
 */
public class SynchronizedClassStatic4 implements Runnable {

    private static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    private static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

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

    private static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static形式。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}

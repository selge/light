package com.demo.lock;

/**
 * 同时访问同步方法和非同步方法
 *
 * @author xiaol
 * @date 2019/9/20
 */
public class SynchronizedYesAndNo6 implements Runnable {

    private static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }

    private synchronized void method1() {
        System.out.println("我是加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    private void method2() {
        System.out.println("我是没加锁方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().endsWith("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }
}

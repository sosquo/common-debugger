package com.llz.springtest.demos.debug.suspend;

public class SuspendTest implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        long id = thread.getId();
        String name = thread.getName();
        System.out.println("Thread = " + id + " -- " + name);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SuspendTest(), "myT1");
        Thread thread2 = new Thread(new SuspendTest(), "myT2");
        thread1.start();
        thread2.start();
        Thread.sleep(100);
        System.out.println(" ====== ");
    }
}

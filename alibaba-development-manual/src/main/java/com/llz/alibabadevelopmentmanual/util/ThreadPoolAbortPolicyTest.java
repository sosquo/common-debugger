package com.llz.alibabadevelopmentmanual.util;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolAbortPolicyTest implements Runnable {

    static AtomicInteger count = new AtomicInteger();
    public static final int THREAD_SIZE = 100;
    static CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);
    static ExecutorService executorService = new ThreadPoolExecutor(0,
            20,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new NamedThreadFactory("abortPoolTest", false),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_SIZE; i++) {
            ThreadPoolAbortPolicyTest thread = new ThreadPoolAbortPolicyTest();
            try {
                executorService.execute(thread);
            } catch (RejectedExecutionException e) {
                System.out.println("队列已满，拒绝服务！！！");
            }
        }
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("count.get() = " + count.get());
        executorService.shutdown();
    }

    @Override
    public void run() {
        try {
            count.incrementAndGet();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

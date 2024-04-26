package com.llz.alibabadevelopmentmanual.util;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicMethodTest {

    /**
     * 每个AtomicTest类累加的次数
     */
    public static final int ADD_TIME = 1000;
    /**
     * 每次手动累加的值
     */
    public static final int DELTA = 5;
    static AtomicLong atomicLong = new AtomicLong();
    static LongAdder longAdder = new LongAdder();
    static LongAccumulator longAccumulator = new LongAccumulator(Math::addExact, 0);
    /**
     * 门栓数量
     */
    public static final int LATCH_COUNT = ADD_TIME * 3;
    static CountDownLatch countDownLatch = new CountDownLatch(LATCH_COUNT);
    /**
     * 线程池队列长度
     */
    public static final int THREAD_TOOL_CAPACITY = LATCH_COUNT;
    static ExecutorService executorService = new ThreadPoolExecutor(10,
            20,
            500,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(THREAD_TOOL_CAPACITY),
            new NamedThreadFactory("river", false),
            new ThreadPoolExecutor.AbortPolicy());

    public AtomicMethodTest() {
    }

    public static void main(String[] args) throws InterruptedException {
        new AtomicMethodTest().testAtomic();
        countDownLatch.await(10, TimeUnit.SECONDS);
        long count = countDownLatch.getCount();
        System.out.println("门闩数量 = " + LATCH_COUNT);
        System.out.println("被拒绝执行的count = " + count);
        executorService.shutdown();
        System.out.println("atomicLong.get() = " + atomicLong.get());
        System.out.println("longAdder.sum() = " + longAdder.sum());
        System.out.println("longAccumulator.get() = " + longAccumulator.get());
        System.out.println(" = happy ending = ");
    }

    void testAtomic() {
        testAtomicLong();
        testLongAdder();
        testLongAccumulate();
    }

    void testAtomicLong() {
        for (int i = 0; i < ADD_TIME; i++) {
            AtomicLongTest command = new AtomicLongTest();
            try {
                executorService.execute(command);
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("testAtomicLong 被拒绝了！！！");
            }
        }
    }

    void testLongAdder() {
        for (int i = 0; i < ADD_TIME; i++) {
            try {
                executorService.execute(new LongAdderTest());
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("testLongAdder 被拒绝了！！！");
            }
        }
    }

    void testLongAccumulate() {
        for (int i = 0; i < ADD_TIME; i++) {
            try {
                executorService.execute(new LongAccumulateTest());
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("testLongAccumulate 被拒绝了！！！");
            }
        }
    }

    class AtomicLongTest implements Runnable {

        @Override
        public void run() {
            atomicLong.incrementAndGet();
            atomicLong.addAndGet(DELTA);
            atomicLong.accumulateAndGet(DELTA, Math::addExact);
            countDownLatch.countDown();
        }
    }

    class LongAdderTest implements Runnable {
        @Override
        public void run() {
            longAdder.increment();
            longAdder.add(DELTA);
            longAdder.add(DELTA);
            countDownLatch.countDown();
        }
    }

    class LongAccumulateTest implements Runnable {
        @Override
        public void run() {
            longAccumulator.accumulate(1);
            longAccumulator.accumulate(DELTA);
            longAccumulator.accumulate(DELTA);
            countDownLatch.countDown();
        }
    }
}
package com.llz.springtest.demos.debug.passcount;

public class PassCountTest {

    public static void main(String[] args) {
        PassCountTest.passCount();
    }
    /**
     * 每经过几次断点，线程挂起
     */
    public static void passCount() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("");
        }
    }
}
package com.llz.springtest.demos.debug.callerfilter;

public class CallerFilterTest {

    public static void main(String[] args) {
        CallerFilterTest.callerFilterA("A", 123);
        CallerFilterTest.callerFilterA();
        CallerFilterTest.callerFilterB();
    }
    /**
     * 1、支持?/*等通配符
     * 2、注意方法带参则最后要加上;或者通配符
     * 3、Ljava/lang/String; 注意不是 Ljava.lang.String;
     * 4、貌似仅支持直接调用、不支持间接调用
     * 5、不加这个条件 则 相当于 *
     * 示例 com.llz.springtest.demos.debug.callerfilter.CallerFilterTest.*A*(Ljava/lang/String;Ljava/lang/?nteger;)*
     *
     * @param name
     * @param id
     */
    public static void callerFilterA(String name, Integer id) {
        System.out.println("Invoke A" + " name: " + name + " id: " + id);
        callerFilterB();
        callerFilterC();
    }

    public static void callerFilterA() {
        System.out.println("Invoke A1");
        callerFilterC();
    }

    public static void callerFilterB() {
        System.out.println("Invoke B");
        callerFilterC();
    }

    public static void callerFilterC() {
        System.out.println("Invoke C");
    }
}
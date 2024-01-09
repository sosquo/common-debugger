package com.llz.springtest.demos.debug.instancefilter;

public class InstanceFiltersTest {

    public static void main(String[] args) {
        InstanceFiltersTest test1 = new InstanceFiltersTest();
        InstanceFiltersTest test2 = new InstanceFiltersTest();
        InstanceFiltersTest test3 = new InstanceFiltersTest();
        test1.invoke("1");
        test2.invoke("2");
        test3.invoke("3");
        System.out.println(" === ");
    }

    /**
     * exp: 500 507 -> 捕获实例id为500和507的InstanceFiltersTest
     * @param id
     */
    private void invoke(String id) {
        System.out.print("");
    }
}

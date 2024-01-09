package com.llz.springtest.demos.debug.instancefilter;

public class InstanceFiltersIndirectTest {


    public static void main(String[] args) {
        InstanceFiltersIndirectTest test1 = new InstanceFiltersIndirectTest();
        InstanceFiltersIndirectTest test2 = new InstanceFiltersIndirectTest();
        InstanceFiltersIndirectTest test3 = new InstanceFiltersIndirectTest();
        test1.invoke0("1");
        test2.invoke0("2");
        test3.invoke0("3");
        System.out.println(" === ");
    }

    private void invoke0(String id) {
        invoke1(id);
    }
    private void invoke1(String id) {
        invoke2(id);
    }

    /**
     * 支持方法间接调用(前提是同一个实例。。。)
     * exp: 500 507 -> 捕获实例id为500和507的InstanceFiltersTest
     * @param id
     */
    private void invoke2(String id) {
        System.out.print("");
    }
}

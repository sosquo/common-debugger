package com.llz.springtest.demos.debug.instancefilter;


public class InstanceFiltersStaticTest {


    public static void main(String[] args) {
        InstanceFiltersStaticTest test1 = new InstanceFiltersStaticTest();
        InstanceFiltersStaticTest test2 = new InstanceFiltersStaticTest();
        InstanceFiltersStatic.invoke(test1);
        InstanceFiltersStatic.invoke(test2);
        InstanceFiltersStatic filtersStatic = new InstanceFiltersStatic();
        filtersStatic.invoke(test1);
        System.out.println(" === ");
    }


}

package com.llz.springtest.demos.debug.instancefilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstanceFiltersIndirectTest1 {


    /**
     * 不支持list/map包装，支持调用者实例id
     * @param args
     */
    public static void main(String[] args) {
        InstanceFiltersIndirectTest1 instance = new InstanceFiltersIndirectTest1();
        InstanceFiltersIndirectTest1 test1 = new InstanceFiltersIndirectTest1();
        InstanceFiltersIndirectTest1 test2 = new InstanceFiltersIndirectTest1();
        List<InstanceFiltersIndirectTest1> list1 = new ArrayList<>();
        List<InstanceFiltersIndirectTest1> list2 = new ArrayList<>();
        Map<String, InstanceFiltersIndirectTest1> map1 = new HashMap<>();
        Map<String, InstanceFiltersIndirectTest1> map2 = new HashMap<>();
        list1.add(test1);
        list2.add(test2);
        map1.put("test1", test1);
        map2.put("test3", test2);
        instance.invokeList(list1);
        instance.invokeList(list2);
        instance.invokeMap(map1);
        instance.invokeMap(map2);
        instance.invokeInstance(test1);
        System.out.println(" === ");
    }

    private void invokeList(List list) {
        System.out.print("");
    }

    private void invokeMap(Map map) {
        System.out.print("");
    }

    private void invokeInstance(InstanceFiltersIndirectTest1 test1) {
        System.out.print("");
    }
}

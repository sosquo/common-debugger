package com.llz.alibabadevelopmentmanual.util;

public class SwitchTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("testIfNullSwitch(null) = " + testIfNullSwitch(null));
        System.out.println("testMultiCaseSwitch() = " + testMultiCaseSwitch(7));
    }

    private static Integer testMultiCaseSwitch(Integer key) {
        Integer value = 0;
        switch (key) {
            default:
                value++;
//                break;
            case 1:
                value++;
            case 2:
                value++;
            case 3:
                value++;
                break;
            case 4:
                value++;
        }
        return value;

    }

    private static String testIfNullSwitch(String s) {
        String result = "";
        switch (s) {
            case "a":
                result = "apple";
                break;
            case "b":
                result = "banana";
                break;
            case "c":
                result = "cap";
                break;
            default:
                break;
        }
        return result;
    }
}

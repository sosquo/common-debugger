package com.llz.springtest.demos.debug.classfilter;

public class ClassFiltersTest {

    public static void main(String[] args) {
        ClassFiltersTest filtersTest = new ClassFiltersTest();
        B b = filtersTest.new B();
        C c = filtersTest.new C();
        b.test("B");
        c.test("C");
    }

    class A {
        public void testA(String name) {
            System.out.print("");
        }
    }

    class B {
        A a = new A();

        public void test(String name) {
            a.testA(name);
        }
    }

    class C {
        A a = new A();

        public void test(String name) {
            a.testA(name);
        }
    }
}

package com.llz.springtest.demos.debug.instancefilter;

public class IndirectInstanceFilter {

    public static void main(String[] args) {
        IndirectInstanceFilter filter = new IndirectInstanceFilter();
        A a = filter.new A();
        a.a();
    }
    class A {
        B b = new B();
        public void a() {
            System.out.println("a");
            b.b();
        }
    }

    class B {
        C c = new C();
        public void b() {
            System.out.println("b");
            c.c();
        }
    }

    class C {
        public void c() {
            System.out.println("c");
        }
    }
}

package com.llz.springtest.demos.debug.disablentill;

public class DisableUntilTest {

    public static void main(String[] args) {
        DisableUntilTest disableUntilTest = new DisableUntilTest();
        disableUntilTest.C(1);
        disableUntilTest.A(1);
        disableUntilTest.B(1);

        disableUntilTest.C(2);
        disableUntilTest.A(2);
        disableUntilTest.B(2);
    }

    public void A(Integer id) {
        System.out.println(" A----A ");
//        D("A" + id);
    }

    public void B(Integer id) {
        D("B" + id);
    }

    public void C(Integer id) {
        D("C" + id);
    }
    public void D(String type) {
        System.out.print("");
    }
}

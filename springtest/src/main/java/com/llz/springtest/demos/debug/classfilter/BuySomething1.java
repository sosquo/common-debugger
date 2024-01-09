package com.llz.springtest.demos.debug.classfilter;

public class BuySomething1 {

    public BuySomething1(Clothes clothes) {
        this.clothes = clothes;
    }

    Clothes clothes;

    public void buyCloth() {
        System.out.println("买了 = " + clothes.getClothName());
    }


    public static void main(String[] args) {
        BuySomething1 pants1 = new BuySomething1(new Clothes.Pants(1));
        BuySomething1 tShirt1 = new BuySomething1(new Clothes.TShirt());
        BuySomething1 pants2 = new BuySomething1(new Clothes.Pants(2));
        BuySomething1 shoot = new BuySomething1(new Clothes.Shoot());
        pants1.buyCloth();
        tShirt1.buyCloth();
        pants2.buyCloth();
        shoot.buyCloth();
    }
}

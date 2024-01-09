package com.llz.springtest.demos.debug.classfilter;

public interface Clothes {

    /**
     * 类过滤器（仅适用于接口?），exp: com.llz.springtest.demos.debug.classfilter.Clothes$Shoot
     * @return
     */
    String getClothName();


    class Pants implements Clothes{

        private int id;

        public Pants(int id) {
            this.id = id;
        }

        @Override
        public String getClothName() {
            return "裤子" + id;
        }

    }

    class Shoot implements Clothes{

        @Override
        public String getClothName() {
            return "鞋子";
        }
    }

    class TShirt implements Clothes{

        @Override
        public String getClothName() {
            return "短袖";
        }
    }
}

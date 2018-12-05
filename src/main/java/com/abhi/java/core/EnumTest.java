package com.abhi.java.core;

/**
 * Created by abhdogra1 on 12/4/2018.
 */
public enum EnumTest {
    RED(1){
        public void print(){
            System.out.println(this.getValue());
        }
    },BLUE(2){
        public void print(){
            System.out.println(this.getValue());
        }
    },YELLOW(3){
        public void print(){
            System.out.println(this.getValue());
        }
    };

    private int value;
    EnumTest(int i) {
        this.value = i;
    }

    public int getValue(){
        return this.value;
    }

    public abstract void print();

    public static void main(String[] args){
        for(EnumTest e : EnumTest.values()){
            e.print();
            System.out.println(e.getValue());
            System.out.println(e.name());
            System.out.println("to string");
            System.out.println(e.toString());
            System.out.println("ordinal");
            System.out.println(e.ordinal());
        }
    }

}

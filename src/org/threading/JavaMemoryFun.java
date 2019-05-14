package org.threading;

/**
 * Java is pass by value but for references memory/location of the obj is passed
 * Inside the method if a new reference is created the original obj doesn't get modified
 * */

public class JavaMemoryFun {
    Integer myInteger = 0;

    public static void main(String[] args){
//        Modifier modifier1 = new Modifier();
//        modifier1.run();

        Integer outsideInteger = new Integer(8);
        modify(outsideInteger);
        System.out.println("Outside Integer " +  outsideInteger);

        Dog dog = new Dog("Shubha");
        modify(dog);
        System.out.println(dog.name);
    }

    public static void modify(Integer myInteger){ //copy of myInteger reference
        myInteger++; //create New
        myInteger = 9;
        System.out.println("Inside modify: " + myInteger);
    }

    public static void modify(final Dog dog){
        dog.name = "SuperDog";
    }

//    public static void print(Integer myInteger){
//        System.out.println(Thread.currentThread().getName() + " says " );
//    }
}

class Dog{
    String name;
    public Dog(String name){
        this.name = name;
    }
}

class Modifier implements Runnable{

    @Override
    public void run(){
//        JavaMemoryFun.print();
    }
}
package org.threading;

/*
* Synchronized method usage. Ten threads modify an integer
* */

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadingFun {
    private Integer modifyMe = 0;
    Person person = new Person();

    @Test
    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true){
            executorService.execute(new Modifier1());
        }
    }

    //How to access modifyMe ?
    class Modifier1 implements Runnable{

        @Override
        public void run(){
            System.out.println("   ");
            System.out.println(Thread.currentThread().getName() + " before " + person.age );
            modify(person);
            System.out.println(Thread.currentThread().getName() + " after " + person.age );
            System.out.println("   ");
            try {
                Thread.sleep(3*1000);
            } catch (Exception e){

            }
        }

        private void modify(Person person){
            person.age++;
        }
    }

    class Person{
        public Integer age = 0;
    }
}

package org.threading;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SingleLaneBridge {

    public static void main(String[] args){
        final Bridge bridge = new Bridge();
        Thread NB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep((long)Math.random()*10);
                        Vehicle vehicle = new Vehicle("A - " + Math.random()*10, bridge);
                        vehicle.run();
                    } catch (InterruptedException iex){
                        iex.printStackTrace();
                    }
                }
            }
        });
        Thread SB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    try {
                        TimeUnit.SECONDS.sleep((long)Math.random()*10);
                        Vehicle vehicle = new Vehicle("B - " + Math.random()*10, bridge);
                        vehicle.run();
                    } catch (InterruptedException iex){
                        iex.printStackTrace();
                    }
                }
            }
        });

        NB.start();
        SB.start();
    }

}
class  Vehicle implements Runnable{
    String name;
    Bridge bridge;

    public Vehicle(String name, Bridge bridge){
        this.name = name;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        this.bridge.cross(this);
    }
}

/*
* Single Lane Bridge
* */
class Bridge {
    public final Semaphore semaphore;

    public Bridge(){
        semaphore = new Semaphore(1);
    }

    public void cross(Vehicle vehicle){
        try {
            System.out.println(String.format("%s is trying to acquire the lock", vehicle.name));
            semaphore.acquire();
            System.out.println(String.format("%s acquired the lock & is crossing the bridge", vehicle.name));
            TimeUnit.SECONDS.sleep((long)Math.random()*10);
        } catch (InterruptedException iex){
            iex.printStackTrace();
        } finally {
            System.out.println(String.format("%s crossed the bridge", vehicle.name));
            System.out.println(String.format("%s is releasing the lock", vehicle.name));
            semaphore.release();
        }
    }
}
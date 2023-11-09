package org.example;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {
    private int lunches;
    private String name;
    private boolean check = true;
    Random random = new Random();

    ReentrantLock lock = new ReentrantLock();

    public Philosopher(int lunches, String name) {
        this.lunches = lunches;
        this.name = name;
    }

    public int getLunches() {
        return lunches;
    }

    public void setLunches(int lunches) {
        this.lunches = lunches;
    }

    @Override
    public void run() {
            while (lunches != 4) {
                thinking();
                eating();
            }
            System.out.println(this.name + " съел три порции блюда.");
    }

    public void eating() {
        synchronized (Philosopher.class)
        {
            System.out.println(this.name + " начал обедать.");
            try {
                sleep(500);
                System.out.println(this.name + " съел всего столько порций: " + lunches);
                lunches++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void thinking() {
        System.out.println(this.name + " начал размышлять.");
        int thinkingTime = random.nextInt(1000);
        try {
            sleep(thinkingTime);
            System.out.println(this.name + " размышлял " + thinkingTime + " миллисекунд");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

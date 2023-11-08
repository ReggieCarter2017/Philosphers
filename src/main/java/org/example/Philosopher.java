package org.example;

import java.util.Random;

public class Philosopher extends Thread {
    private int lunches;
    private String name;
    private boolean check = true;
    Random random = new Random();

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
        synchronized (this) {
            while (lunches != 4) {
                if (check) {
                    eating();
                } else {
                    thinking();
                }
            }
            System.out.println("Философ №" + this.name + " съел три порции блюда.");
        }
    }

    public void eating() {
        synchronized (this) {
            check = false;
            System.out.println(this.name + " начал обедать.");
            try {
                sleep(500);
                System.out.println(this.name + " съел всего столько порций: " + lunches);
                lunches++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            check = true;
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

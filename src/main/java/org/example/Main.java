package org.example;

import java.util.concurrent.atomic.AtomicInteger;

class Main {
    private static int a, c, d, e = 0;
    private static final AtomicInteger lunches = new AtomicInteger();
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(1, "Philosopher №" + (i+1));
            philosopher.start();
        }
    }
}
package org.example;

import java.util.concurrent.atomic.AtomicInteger;

class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(1, "Philosopher №" + (i+1));
            philosopher.start();
        }
    }
}

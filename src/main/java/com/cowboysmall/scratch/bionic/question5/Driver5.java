package com.cowboysmall.scratch.bionic.question5;

public class Driver5 {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new Racer("1"));
        Thread t2 = new Thread(new Racer("2"));
        Thread t3 = new Thread(new Racer("3"));
        Thread t4 = new Thread(new Racer("4"));
        Thread t5 = new Thread(new Racer("5"));

        t5.start();
        t3.start();
        t1.start();

        // only t5, t3, and t1 have started. Calling thread waits till
        // t3 has ended, hence only t5, t3, or t1
        t3.join();

        t2.start();

        t1.join();

        t4.start();

        t2.join();
        t4.join();
        t5.join();
    }
}

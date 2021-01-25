package com.cowboysmall.scratch.bionic.question5;

public class Racer implements Runnable {

    private String name;

    public Racer(String name) {

        this.name = name;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(100);
            System.out.println(name);

        } catch (InterruptedException e) {

        }
    }
}

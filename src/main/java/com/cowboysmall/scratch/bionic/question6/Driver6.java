package com.cowboysmall.scratch.bionic.question6;

public class Driver6 {

    public static void main(String[] args) {

        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}

package com.steady.d4_abstract.test_door;

public class test {
    public static void main(String[] args) {
        Door dx = new X_door(190,65,"mxm");
        System.out.println(dx.getName());
        System.out.println(dx.getHeight());
        System.out.println(dx);

        Door dp = new P_door(180,75,"sfs");
        System.out.println(dp.getHeight());
        System.out.println(dp);
    }
}

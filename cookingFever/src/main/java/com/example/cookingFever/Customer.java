package com.example.cookingFever;

public class Customer {
    private long customerTime;
    private double maxTime;

    Customer(int level) {
        customerTime = System.nanoTime();
        if(Math.random() > .1) {
            if (level == 1) {
                maxTime = 7;
            }

            if (level == 2) {
                maxTime = 6.5;
            }

            if (level == 3) {
                maxTime = 6;
            }

            if (level == 4) {
                maxTime = 5.5;
            }

            if (level == 5) {
                maxTime = 5;
            }
        }
        else {
            maxTime = 3.5;
        }
    }
}

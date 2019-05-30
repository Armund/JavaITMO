package ru.billing.sync;

public class Bank {
    private int intTo, intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout){
        System.out.println("before Thread = " + Thread.currentThread().getName() + ", From: " + intFrom
                + ", to: " + intTo);
        intFrom-=intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intTo+=intTransaction;
        System.out.println("After Thread = " + Thread.currentThread().getName() + ", From: " + intFrom
                + ", to: " + intTo);

    }


}


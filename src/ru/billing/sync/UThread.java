package ru.billing.sync;

public class UThread extends Thread {

    private Bank bankWork;
    private Bank bankWork1;
    private int intTrans;
    private long lngSleep;

    public UThread(Bank bankWork, int intTrans, long lngSleep, Bank bankWork1) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
        this.bankWork1 = bankWork1;
    }

    public void run() {
        synchronized (bankWork) {
            bankWork.calc(intTrans, lngSleep);
                synchronized (bankWork1) {
                    System.out.println("Lock");
                }
            }
        }
    }

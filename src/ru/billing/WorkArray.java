package ru.billing;

public class WorkArray<T extends Number> {
    T[] arrNums;

    public WorkArray(T[] numP) {
        arrNums = numP;
    }

    public double sum() {
        double doubleWork = 0;
        for (int i = 0; i < arrNums.length; i++) {
            doubleWork += arrNums[i].doubleValue();
        }
        return doubleWork;
    }
}

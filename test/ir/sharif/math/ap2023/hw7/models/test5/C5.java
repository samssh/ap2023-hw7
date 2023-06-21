package ir.sharif.math.ap2023.hw7.models.test5;

import ir.sharif.math.ap2023.hw7.SetValue;

public class C5 {

    @SetValue(path = "../b1")
    int c1;

    @SetValue(path = "../b2")
    int c2;

    int c3;

    @Override
    public String toString() {
        return "C5{" +
                "c1=" + c1 +
                ", c2=" + c2 +
                ", c3=" + c3 +
                '}';
    }
}

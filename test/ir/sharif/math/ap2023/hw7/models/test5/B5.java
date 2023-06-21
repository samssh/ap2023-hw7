package ir.sharif.math.ap2023.hw7.models.test5;

import ir.sharif.math.ap2023.hw7.SetValue;

public class B5 {

    @SetValue(path = "c5/c2")
    int b1;

    @SetValue(path = "../a1")
    int b2;

    C5 c5;

    @Override
    public String toString() {
        return "B5{" +
                "b1=" + b1 +
                ", b2=" + b2 +
                ", c5=" + c5 +
                '}';
    }
}

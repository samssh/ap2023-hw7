package ir.sharif.math.ap2023.hw7.models.test8;

import ir.sharif.math.ap2023.hw7.SetValue;

public class B8 {
    int a;
    @SetValue(path = "../b")
    public B8 b;
    @SetValue(path = "..")
    public A8 aa;

    B8() {
    }

    B8(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
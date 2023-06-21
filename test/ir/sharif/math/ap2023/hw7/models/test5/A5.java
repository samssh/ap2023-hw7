package ir.sharif.math.ap2023.hw7.models.test5;

import ir.sharif.math.ap2023.hw7.SetValue;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public class A5 {

    @SetValue(path = "b5/c5/c3")
    int a1;

    int a2;

    B5 b5;

    @Override
    public String toString() {
        return "A5{" +
                "a1=" + a1 +
                ", a2=" + a2 +
                ", b5=" + b5 +
                '}';
    }
}

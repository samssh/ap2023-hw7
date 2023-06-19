package ir.sharif.math.ap2023.hw7.models.sample4;

import ir.sharif.math.ap2023.hw7.SetValue;

public class A {
    B b;
    @SetValue(path = "b")
    B bb;
    @SetValue(path = "")
    A aa;


    private A() {
    }
}

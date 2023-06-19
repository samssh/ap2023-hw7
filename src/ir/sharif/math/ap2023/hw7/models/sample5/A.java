package ir.sharif.math.ap2023.hw7.models.sample5;

import ir.sharif.math.ap2023.hw7.SetValue;

public class A {
    B b;
    @SetValue(path = "b/x")
    int i;

    private A() {
    }
}

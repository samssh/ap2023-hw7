package ir.sharif.math.ap2023.hw7.models.sample2;

import ir.sharif.math.ap2023.hw7.Name;

public class A {
    @Name(name = "salam")
    private final int a;

    private A() {
        this.a = 8;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "A{" + "a=" + a + '}';
    }
}

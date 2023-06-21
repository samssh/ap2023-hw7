package ir.sharif.math.ap2023.hw7.models.test5;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.SetValue;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public class A5 {

    @SetValue(path = "b5/b1")
    int a1;

    @Name(name = "a22")
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

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public B5 getB5() {
        return b5;
    }

    public void setB5(B5 b5) {
        this.b5 = b5;
    }
}

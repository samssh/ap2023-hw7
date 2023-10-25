package ir.sharif.math.ap2023.hw7.models.test8;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.SetValue;

import java.util.Arrays;

public class A8 {
    @Name(name = "salam")
    private final int a;
    long l;

    String getPointer() {
        return super.toString();
    }


    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", l=" + l +
                ", b=" + b +
                ", bb=" + bb +
                ", aa=" + (aa == this) +
                ", c=" + Arrays.toString(c) +
                '}';
    }

    public B8 b;
    @SetValue(path = "b")
    public B8 bb;
    @SetValue(path = "")
    public A8 aa;

    C8[] c;


    private A8() {
        a = 8;
    }

    public int getA() {
        return a;
    }

    public long getL() {
        return l;
    }

    public C8[] getC() {
        return c;
    }
}

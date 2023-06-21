package ir.sharif.math.ap2023.hw7.models.test5;

import ir.sharif.math.ap2023.hw7.SetValue;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public class B5 {

    int b1;

    static int b2 = 8;

    @SetValue(path = "../a22")
    static int b3 = 7;

    public B5() {
        this.b1 = 1;
    }

    @UseAsConstructor(args = {})
    static B5 cons() {
        B5 b5 = new B5();
        b5.b1 = 5;
        return b5;
    }

    @Override
    public String toString() {
        return "B5{" +
                "b1=" + b1 +
                ", b2=" + b2 +
                ", b3=" + b3 +
                '}';
    }

    public static int getB3() {
        return b3;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    public int getB2() {
        return b2;
    }

    public void setB2(int b2) {
        this.b2 = b2;
    }
}

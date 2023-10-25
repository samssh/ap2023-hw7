package ir.sharif.math.ap2023.hw7.models.test6;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public class B6 {

    private C6 c6;

    @Name(name = "w")
    double j;

    @UseAsConstructor(args = {})
    static B6 cons() {
        B6 b6 = new B6();
        b6.j = 56;
        return b6;
    }

    public B6() {
        j = 5;
    }

    @Override
    public String toString() {
        return "B6{" +
                "c6=" + c6 +
                ", j=" + j +
                '}';
    }

    public C6 getC6() {
        return c6;
    }

    public void setC6(C6 c6) {
        this.c6 = c6;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }
}

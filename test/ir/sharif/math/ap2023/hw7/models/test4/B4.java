package ir.sharif.math.ap2023.hw7.models.test4;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.SetValue;

public class B4 {

    @Name(name = "k1")
    private int k;

    private C4 c4;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public C4 getC4() {
        return c4;
    }

    public void setC4(C4 c4) {
        this.c4 = c4;
    }


    @Override
    public String toString() {
        return "B4{" +
                "k1=" + k +
                ", c4=" + c4 +
                '}';
    }
}

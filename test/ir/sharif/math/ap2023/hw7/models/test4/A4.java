package ir.sharif.math.ap2023.hw7.models.test4;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.SetValue;

public class A4 {

    @Name(name = "mm")
    private int k = 5;

    @Name(name = "cs")
    B4 b4;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public B4 getB4() {
        return b4;
    }

    public void setB4(B4 b4) {
        this.b4 = b4;
    }

    @Override
    public String toString() {
        return "A4{" +
                "k=" + k +
                ", b4=" + b4 +
                '}';
    }
}

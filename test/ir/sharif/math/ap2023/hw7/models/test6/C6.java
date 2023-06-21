package ir.sharif.math.ap2023.hw7.models.test6;

import ir.sharif.math.ap2023.hw7.SetValue;

public class C6 {

    @SetValue(path = "../w")
    double t;

    @SetValue(path = "../../k")
    int u;

    @Override
    public String toString() {
        return "C6{" +
                "t=" + t +
                ", u=" + u +
                '}';
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }
}

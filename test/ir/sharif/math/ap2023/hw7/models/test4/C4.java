package ir.sharif.math.ap2023.hw7.models.test4;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.SetValue;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public class C4 {

    private String name;

    @SetValue(path = "../k1")
    private int k;

    @Name(name = "z")
    private int b = 56;

    public C4() {
        this.name = "a";
        this.k = 1;
    }

    @UseAsConstructor(args = {})
    static C4 constructor(){
        C4 c4 = new C4();
        c4.k = 2;
        c4.name = "ali";
        return c4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "C4{" +
                "name='" + name + '\'' +
                ", k=" + k +
                ", b=" + b +
                '}';
    }
}

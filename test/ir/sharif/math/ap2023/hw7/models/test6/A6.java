package ir.sharif.math.ap2023.hw7.models.test6;

import ir.sharif.math.ap2023.hw7.Name;

public class A6 {

    private B6 b6;

    int k;

    @Name(name = "name1")
    String name;

    public A6() {
        name = "ali";
    }

    @Override
    public String toString() {
        return "A6{" +
                "b6=" + b6 +
                ", k=" + k +
                ", name='" + name + '\'' +
                '}';
    }

    public B6 getB6() {
        return b6;
    }

    public void setB6(B6 b6) {
        this.b6 = b6;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

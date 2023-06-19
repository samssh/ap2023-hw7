package ir.sharif.math.ap2023.hw7.models.sample1;

public class A {
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

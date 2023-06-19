package ir.sharif.math.ap2023.hw7.models.test2;

import ir.sharif.math.ap2023.hw7.Name;

public class A2 {

    @Name(name = "bool")
    private boolean aBoolean = false;

    @Name(name = "adad")
    private int anInt;

    private long aLong;

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }
}

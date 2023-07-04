package ir.sharif.math.ap2023.hw7.models.test8;

import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public abstract class C8 {
    public int a;
    public int b;

    @UseAsConstructor(args = {"type"})
    static C8 constructor(String type) {
        switch (type) {
            case "CA": return new Ca();
            case "CB": return new Cb();
        }
        return null;
    }
}

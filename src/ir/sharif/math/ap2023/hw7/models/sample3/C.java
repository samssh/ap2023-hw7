package ir.sharif.math.ap2023.hw7.models.sample3;

import ir.sharif.math.ap2023.hw7.UseAsConstructor;

public abstract class C {
    int a, b;

    @UseAsConstructor(args = {"type"})
    static C constructor(String type) {
        switch (type) {
            case "CA":
                return new Ca();
            case "CB":
                return new Cb();
        }
        return null;
    }
}

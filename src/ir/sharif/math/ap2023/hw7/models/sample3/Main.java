package ir.sharif.math.ap2023.hw7.models.sample3;

import ir.sharif.math.ap2023.hw7.ObjectMaker;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> valuesCa = new HashMap<>();
        valuesCa.put("type", "CA");
        valuesCa.put("a", 2);
        valuesCa.put("b", 3);
        valuesCa.put("c", 3);
        C ca = (C) objectMaker.makeObject(valuesCa, "ir.sharif.math.ap2023.hw7.sample3.C");
        System.out.println(ca); // Ca{c=3, a=2, b=3}

        Map<String, Object> valuesCb = new HashMap<>();
        valuesCb.put("type", "CB");
        valuesCb.put("a", 2);
        valuesCb.put("b", 3);
        valuesCb.put("h", 3);
        C cb = (C) objectMaker.makeObject(valuesCb, "ir.sharif.math.ap2023.hw7.sample3.C");
        System.out.println(cb); // Cb{h=3, a=2, b=3}
    }
}

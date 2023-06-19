package ir.sharif.math.ap2023.hw7.models.sample4;

import ir.sharif.math.ap2023.hw7.ObjectMaker;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        Map<String, Object> valuesB = new HashMap<>();
        valuesB.put("x", 4);
        values.put("b", valuesB);
        A a = (A) objectMaker.makeObject(values, "ir.sharif.math.ap2023.hw7.models.sample4.A");
        System.out.println(a.b == a.bb); // true
        System.out.println(a == a.aa); // true
        System.out.println(a.b.x + "," + a.bb.x); // 4,4
    }
}

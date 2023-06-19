package ir.sharif.math.ap2023.hw7.models.sample5;

import ir.sharif.math.ap2023.hw7.ObjectMaker;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        Map<String, Object> valuesB = new HashMap<>();
        valuesB.put("x", 5);
        values.put("b", valuesB);
        A a = (A) objectMaker.makeObject(values, "ir.sharif.math.ap2023.hw7.models.sample5.A");
        System.out.println(a.b.x + "," + a.i); // 5,5
    }
}

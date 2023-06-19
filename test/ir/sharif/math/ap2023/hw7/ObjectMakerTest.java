package ir.sharif.math.ap2023.hw7;

import ir.sharif.math.ap2023.hw7.models.test1.A1;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ObjectMakerTest {

    @Test
    public void test1() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        values.put("aBoolean", true);
        values.put("aByte", (byte) 123);
        values.put("aShort", (short) 122);
        values.put("anInt", 13);
        values.put("aLong", 14L);
        values.put("aDouble", 15.23);
        values.put("aFloat", (float) 14.3);
        values.put("string", "scsdj");

        A1 a1 = (A1) objectMaker.makeObject(values, A1.class.getName());

        assertTrue(a1.isaBoolean());
        assertEquals(a1.getaByte(), 123);
        assertEquals(a1.getaShort(), 122);
        assertEquals(a1.getAnInt(), 13);
        assertEquals(a1.getaLong(), 14);
        assertEquals(a1.getaDouble(), 15.23, 0.5);
        assertEquals(a1.getaFloat(), 14.3, 0.5);
        assertEquals(a1.getString(), "scsdj");
    }
}
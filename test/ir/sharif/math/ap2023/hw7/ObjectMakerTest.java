package ir.sharif.math.ap2023.hw7;

import ir.sharif.math.ap2023.hw7.models.test1.A1;
import ir.sharif.math.ap2023.hw7.models.test2.A2;
import ir.sharif.math.ap2023.hw7.models.test3.A3;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ObjectMakerTest {

    /**
     * basic test
     */
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

    /**
     * test to check @Name annotation independently
     */
    @Test
    public void test2() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        values.put("bool", true);
        values.put("adad", 13);
        values.put("aLong", 14L);

        A2 a2 = (A2) objectMaker.makeObject(values, A2.class.getName());

        assertTrue(a2.isaBoolean());
        assertEquals(a2.getAnInt(), 13);
        assertEquals(a2.getaLong(), 14);
    }

    /**
     * test to check @UseAsConstructor annotation independently
     */
    @Test
    public void test3() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        values.put("long", 14L);
        A3 a3 = (A3) objectMaker.makeObject(values, A3.class.getName());
        assertEquals(14L , a3.getAdad());
        assertEquals("sadat" , a3.getName());
        assertEquals(11 , a3.getK());

        values.clear();

        values.put("adad" , 14L);
        A3 a32 = (A3) objectMaker.makeObject(values, A3.class.getName());
        assertEquals(3L , a32.getAdad());
        assertEquals("sadat" , a32.getName());
        assertEquals(11 , a32.getK());

    }
}
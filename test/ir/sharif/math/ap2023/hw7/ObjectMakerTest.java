package ir.sharif.math.ap2023.hw7;

import ir.sharif.math.ap2023.hw7.models.test1.A1;
import ir.sharif.math.ap2023.hw7.models.test2.A2;
import ir.sharif.math.ap2023.hw7.models.test3.A3;
import ir.sharif.math.ap2023.hw7.models.test4.A4;
import ir.sharif.math.ap2023.hw7.models.test5.A5;
import ir.sharif.math.ap2023.hw7.models.test5.B5;
import ir.sharif.math.ap2023.hw7.models.test6.A6;
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

    /**
     * test to check @SetValue annotation for 3 nested classes
     */
    @Test
    public void test4() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        Map<String, Object> valuesB = new HashMap<>();
        Map<String, Object> valuesC = new HashMap<>();

//        valuesC.put("a" , "ali");
        valuesC.put("b" , 57);

        valuesB.put("t" , 4);
        valuesB.put("c4" , valuesC);


        values.put("mm", 6);
        values.put("cs", valuesB);
        A4 a = (A4) objectMaker.makeObject(values, A4.class.getName());
        System.out.println(a.toString()); // 6,6


        assertEquals(values.get("mm") , a.getK());
        assertEquals(values.get("mm") , a.getB4().getK());
        assertEquals(values.get("mm") , a.getB4().getC4().getK());
        assertEquals("ali" , a.getB4().getC4().getName());

    }

    /**
     * combination test 1.
     */
    @Test
    public void test5() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        Map<String, Object> valuesB = new HashMap<>();

        valuesB.put("b2" , 10);
        values.put("a2", 75);
        values.put("a1", 76);
        values.put("b5", valuesB);
        A5 a = (A5) objectMaker.makeObject(values, A5.class.getName());
        System.out.println(a.toString());

        assertEquals(8 , a.getB5().getB2());
        assertEquals(5 , a.getB5().getB1());
        assertEquals(a.getB5().getB1() , a.getA1());
        assertEquals(0 , a.getA2());
        assertEquals(7 , B5.getB3());

    }


    /**
     * combination test 2.
     */
    @Test
    public void test6() throws ReflectiveOperationException {
        ObjectMaker objectMaker = new ObjectMaker();
        Map<String, Object> values = new HashMap<>();
        Map<String, Object> valuesB = new HashMap<>();
        Map<String, Object> valuesC = new HashMap<>();

        valuesB.put("j" , 4);
        valuesB.put("c6" , valuesC);

        values.put("k", 75);
        values.put("b6", valuesB);
        A6 a = (A6) objectMaker.makeObject(values, A6.class.getName());
        System.out.println(a.toString());

        assertEquals(56.0 , a.getB6().getJ() , 0.5);
        assertEquals(a.getB6().getJ() , a.getB6().getC6().getT() , 0.5);
        assertEquals(75 , a.getK());
        assertEquals(a.getK() , a.getB6().getC6().getU());
        assertEquals("ali" , a.getName());


    }
}
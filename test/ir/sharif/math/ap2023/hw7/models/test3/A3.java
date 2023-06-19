package ir.sharif.math.ap2023.hw7.models.test3;

import ir.sharif.math.ap2023.hw7.Name;
import ir.sharif.math.ap2023.hw7.UseAsConstructor;
import ir.sharif.math.ap2023.hw7.models.sample3.Ca;

public class A3 {

    private int k;
    private String name;

    @Name(name = "long")
    private long adad;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAdad() {
        return adad;
    }

    public void setAdad(long adad) {
        this.adad = adad;
    }

    //
//    private static class A3A extends A3 {
//
//        private String username;
//
//        @Name(name = "sen")
//        private int age;
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }
//
//    private static class A3B extends A3{
//
//    }
//


    public A3() {
        k = 10;
        name = "mohammad";
        adad = 2l;
    }

    @UseAsConstructor(args = {"type"})
    static A3 sazande(String type) {
       A3 a3 = new A3();
       a3.adad = 3l;
       a3.k = 11;
       a3.name = "sadat";
       return a3;
    }

    @Override
    public String toString() {
        return "A3{" +
                "k=" + k +
                ", name='" + name + '\'' +
                ", adad=" + adad +
                '}';
    }
}

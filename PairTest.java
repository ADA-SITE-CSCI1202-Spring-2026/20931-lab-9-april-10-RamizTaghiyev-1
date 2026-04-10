import java.util.*;

public class PairTest {
    static int pass = 0;
    static int fail = 0;

    static void ok(String name, boolean val) {
        if (val) {
            System.out.println("pass: " + name);
            pass++;
        } else {
            System.out.println("fail: " + name);
            fail++;
        }
    }

    static void eq(String name, Object a, Object b) {
        ok(name, Objects.equals(a, b));
    }

    static void t1() {
        Pair<String, Integer> p = new Pair<>("hi", 5);
        eq("key", "hi", p.getKey());
        eq("val", 5, p.getValue());
    }

    static void t2() {
        Pair<String, Double> p = Pair.of("pi", 3.14);
        eq("of key", "pi", p.getKey());
        eq("of val", 3.14, p.getValue());
    }

    static void t3() {
        Pair<String, Integer> a = Pair.of("x", 1);
        Pair<String, Integer> b = Pair.of("x", 1);
        Pair<String, Integer> c = Pair.of("y", 2);

        ok("eq", a.equals(b));
        ok("not eq", !a.equals(c));
        ok("hash", a.hashCode() == b.hashCode());
    }

    static void t4() {
        Pair<String, Integer> p = Pair.of("age", 20);
        eq("text", "(age, 20)", p.toString());
    }

    static void t5() {
        Pair<String, Integer> p = Pair.of("old", 7);
        Pair<Integer, Integer> q = p.withKey(9);

        eq("new key", 9, q.getKey());
        eq("same val", 7, q.getValue());
        eq("old key", "old", p.getKey());
    }

    static void t6() {
        Pair<String, Integer> p = Pair.of("count", 5);
        Pair<String, String> q = p.withValue("five");

        eq("same key", "count", q.getKey());
        eq("new val", "five", q.getValue());
        eq("old val", 5, p.getValue());
    }

    static void t7() {
        Pair<String, Integer> p = Pair.of("id", 10);
        Pair<Integer, String> q = p.swap();

        eq("swap key", 10, q.getKey());
        eq("swap val", "id", q.getValue());
    }

    static void t8() {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(Pair.of("b", 3));
        list.add(Pair.of("a", 1));
        list.add(Pair.of("c", 2));

        list.sort(Comparator.comparing(Pair::getValue));

        eq("first", "a", list.get(0).getKey());
        eq("second", "c", list.get(1).getKey());
        eq("third", "b", list.get(2).getKey());
    }

    public static void main(String[] args) {
        t1();
        t2();
        t3();
        t4();
        t5();
        t6();
        t7();
        t8();

        System.out.println("pass: " + pass);
        System.out.println("fail: " + fail);
    }
}
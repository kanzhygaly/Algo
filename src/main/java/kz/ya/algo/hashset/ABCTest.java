/**
 * A a = new A();
 * B b = new B();
 * C c = new C();
 *
 * HashSet set;
 *
 * set = new HashSet();
 * set.add(a);
 * set.add(b);
 * set.add(c);
 * assert set.size() == 3;
 *
 * set = new HashSet();
 * set.add(a);
 * set.add(c);
 * set.add(b);
 * assert set.size() == 2;
 *
 */
package kz.ya.algo.hashset;

import java.util.HashSet;

/**
 *
 * @author YERLAN
 */
public class ABCTest {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        HashSet set;

        set = new HashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(set.size());

        set = new HashSet();
        set.add(a);
        set.add(c);
        set.add(b);
        System.out.println(set.size());
    }
}

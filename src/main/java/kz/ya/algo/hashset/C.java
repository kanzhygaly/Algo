package kz.ya.algo.hashset;

/**
 *
 * @author YERLAN
 */
public class C {

    private static int counter = 0;

    @Override
    public int hashCode() {
        counter += 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (counter < 2) {
            return o == this;
        }
        return true;
    }
}

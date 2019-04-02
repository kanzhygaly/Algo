/**
 * There are two kangaroos on an x-axis ready to jump in the positive direction (i.e, toward positive infinity). The first
 * kangaroo starts at location x1 and moves at a rate of v1 meters per jump. The second kangaroo starts at location
 * x2 and moves at a rate of v2 meters per jump. Given the starting locations and movement rates for each kangaroo,
 * can you determine if they'll ever land at the same location at the same time?
 */
package kz.ya.algo;

import java.util.Scanner;

/**
 *
 * @author YERLAN
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        if ((x1 > x2 && v1 > v2) || (x1 < x2 && v1 < v2)) {
            System.out.println("NO");
            return;
        }
        if (x1 == x2 && v1 == v2) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}

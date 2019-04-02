/**
 * Lena is preparing for important coding competition that is preceded by N sequential preliminary contests. 
 * She believes in "saving luck", and wants to check her theory. Each contest is described by two integers, Li and Ti:
 * - Li is the amount of luck that can be gained by winning the contest. If Lena wins the contest, her luck balance will decrease by Li;
 *   if she loses it, her luck balance will increase by Li.
 * - Ti denotes the contest's importance rating. It's equal to 1 if the contest is important, and it's equal to 0 if it's unimportant.
 * If Lena loses no more than K important contests, what is the maximum amount of luck she can have after competing in all the preliminary 
 * contests? This value may be negative.
 */
package kz.ya.algo;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author YERLAN
 */
public class LuckBalance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N < 1 || N > 100) {
            return;
        }
        int K = in.nextInt();
        if (K < 0 || K > N) {
            return;
        }
        in.nextLine();

        int luck = 0;
        TreeSet<Integer> important = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int L = in.nextInt();
            int T = in.nextInt();

            if (T == 0) {
                luck += L;
            } else {
                important.add(L);
            }
        }

        int counter = 0;
        Iterator<Integer> it = important.descendingIterator();
        while (it.hasNext()) {
            Integer L = important.pollLast();
            if (L == null) {
                break;
            }
            if (counter < K) {
                luck += L;
                counter++;
            } else {
                luck -= L;
            }
        }

        System.out.println(luck);
    }
}

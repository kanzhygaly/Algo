/*
For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values 
of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:
  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Assume that:
N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].

Complexity:
expected worst-case time complexity is O(N*max(abs(A))2);
expected worst-case space complexity is O(N+sum(abs(A))), beyond input storage (not counting the storage required for input arguments).
 */
package kz.ya.algo;

import java.util.Arrays;

/**
 *
 * @author yerlana
 */
public class MinAbsSum {

    public static void main(String[] args) {
        int[] A1 = {1, 5, 2, -2};
        System.out.println("RESULT: " + getMinAbsSum(A1));

//        int[] A2 = {-8, 4, 5, -10, 3};
//        System.out.println(getMinAbsSum(A2));
    }

    public static int getMinAbsSum(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int sumAbs = 0;
        int maxAbs = 0;
        for (int i = 0; i < A.length; i++) { // O(n)
            A[i] = Math.abs(A[i]);
            maxAbs = Math.max(maxAbs, A[i]);
            sumAbs += A[i];
        }
        System.out.println(Arrays.toString(A));
        System.out.println(sumAbs);
        System.out.println(maxAbs);

        int[] counts = new int[maxAbs + 1];
        System.out.println(Arrays.toString(counts));
        for (int i : A) { // O(n)
            counts[i]++;
        }
        System.out.println(Arrays.toString(counts));

        int[] dp = new int[sumAbs + 1];
        for (int i = 0; i < dp.length; i++) { // O(n)
            dp[i] = -1;
        }
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            for (int j = 0; j < sumAbs; j++) {
                if (dp[j] >= 0) {
                    dp[j] = counts[i];
                } else if (j >= i && dp[j - i] > 0) {
                    dp[j] = dp[j - i] - 1;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        int result = sumAbs;
        for (int i = 0; i < sumAbs / 2 + 1; i++) {
            if (dp[i] >= 0) {
                result = Math.min(sumAbs - 2 * i, result);
            }

        }
        return result;
    }
}

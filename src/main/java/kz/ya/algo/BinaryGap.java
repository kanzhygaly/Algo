/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is 
surrounded by ones at both ends in the binary representation of N.
For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The 
number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 
and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of 
length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should 
return 0 if N doesn't contain a binary gap.
For example, given N = 1041 the function should return 5, because N has binary representation 
10000010001 and so its longest binary gap is of length 5.

Assume that:
N is an integer within the range [1..2,147,483,647].
Complexity:
expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
 */
package kz.ya.algo;

/**
 *
 * @author yerlana
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(toBinary(9) + ": " + getBinaryGap(9)); // 2
        System.out.println(toBinary(529) + ": " + getBinaryGap(529)); // 4
        System.out.println(toBinary(20) + ": " + getBinaryGap(20)); // 1
        System.out.println(toBinary(15) + ": " + getBinaryGap(15)); // 0
        System.out.println(toBinary(1041) + ": " + getBinaryGap(1041)); // 5

        System.out.println(toBinary(11) + ": " + getBinaryGap(11)); // 1
        System.out.println(toBinary(19) + ": " + getBinaryGap(19)); // 2
    }

    public static long toBinary(int N) {
        StringBuilder binary = new StringBuilder();
        while (N > 0) {
            int r = N % 2;
            binary.append(r);
            N /= 2;
        }
        return Long.valueOf(binary.reverse().toString());
    }

    public static int getBinaryGap(int N) {
        if (N < 5) {
            return 0;
        }
        int count = 0;
        int maxBinaryGap = 0;
        
        // remove zeros from tail
        while (N > 0 && N%2 == 0) {
            N /= 2;
        }

        while (N > 0) {
            int remainder = N % 2;

            if (remainder == 1) { // end of gap
                if (count > 0) {
                    if (maxBinaryGap < count) {
                        maxBinaryGap = count;
                    }
                    count = 0;
                }
            } else { // gap count
                count++;
            }

            N /= 2;
        }
        return maxBinaryGap;
    }
}

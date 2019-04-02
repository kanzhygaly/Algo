package kz.ya.algo;

import java.util.Arrays;

/**
 *
 * @author YERLAN
 */
public class TransferWise {

    public static void main(String[] args) {
        // 1
        divide(4, 0);

        // 2 
        double d = 10.0 / -0;
        if (d == Double.POSITIVE_INFINITY) {
            System.out.println("Positive infinity");
        } else {
            System.out.println("Negative infinity");
        }

        // 3
        int[] a = {1};
        TransferWise t = new TransferWise();
        t.increment(a);
        System.out.println(a[a.length - 1]);

        // 4
        String s1 = "abc";
        String s2 = "def";
        String s3 = s1.concat(s2.toUpperCase());
        System.out.println(s1 + s2 + s3);

        // 5
        int[] b = {1, 5, 3, 4, 2};
        System.out.println("KDifference: " + KDifference(b, 2));

        // 6
        System.out.println("Integer complement of 100 is " + getIntegerComplement(100));

        // 7
        int A[] = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        System.out.println("Length of Longest Increasing Subsequence is " + findLIS(A));

        // 8
        boolean flag = false;
        if (flag = true) {
            System.out.println("Hello");
        } else {
            System.out.println("Goodbye");
        }

        // 9
        add(5);
    }

    public static void divide(int a, int b) {
        try {
            int c = a / b;
        } catch (Exception ex) {
            System.out.print("Exeption ");
        } finally {
            System.out.println("Finally");
        }
    }

    void increment(int[] i) {
        i[i.length - 1]++;
    }

    static int KDifference(int[] a, int k) {
        int N = a.length;
//        if (N < 5 || k < 0) {
//            return 0;
//        }
//        int count = 0;
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (Math.abs(a[i] - a[j]) == k) {
//                    count++;
//                }
//            }
//        }
        int count = 0;
        Arrays.sort(a);

        int j = 0;
        int v = a[j];
        
        for (int i = 1; i < N; i++) {
            if (a[i] - v == k) {
                count++;
                v = a[++j];
            }
        }

        return count;
    }

    static int getIntegerComplement(int n) {
        // first solution
//        int ones = (Integer.highestOneBit(n) << 1) - 1;
//        return n ^ ones;

        // second solution
        String binaryString = Integer.toBinaryString(n);

        String temp = "";
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                temp += "0";
            } else {
                temp += "1";
            }
        }
        int base = 2;
        int complement = Integer.parseInt(temp, base);

        return complement;
    }

    static int findLIS(int[] s) {
        int length = 1;
        int N = s.length;
        if (N == 1) {
            return length;
        }

        int[] temp = new int[N];
        temp[0] = s[0];

        for (int i = 1; i < N; i++) {
            if (s[i] < temp[0]) {
                temp[0] = s[i];
            } else if (s[i] > temp[length - 1]) {
                temp[length++] = s[i];
            } else {
                int idx = findCeilIndex(temp, -1, length - 1, s[i]);
                temp[idx] = s[i];
            }
        }
        return length;
    }

    static int findCeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static void add(int a) {
        loop:
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (a == 5) {
                    break loop;
                }
                System.out.println(i * j);
            }
        }
    }
}

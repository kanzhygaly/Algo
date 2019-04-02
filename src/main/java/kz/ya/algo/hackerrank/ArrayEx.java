package kz.ya.algo.hackerrank;

import java.util.Arrays;

/**
 *
 * @author yerlana
 */
public class ArrayEx {

    static int hourglassSum(int[][] arr) {
        int ROW = arr.length;
        int COL = arr[0].length;
        if (ROW != COL) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum;

        // total number of hour glass is (ROW-2)*(COL-2)
        for (int i = 0; i < ROW - 2; i++) {
            for (int j = 0; j < COL - 2; j++) {
                // hour glass sum
                sum = (arr[i][j] + arr[i][j + 1] + arr[i][j + 2])
                        + (arr[i + 1][j + 1])
                        + (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    // Time: O(d*n), Space: O(1)
    static int[] rotLeft(int[] a, int d) {
        int count = 0;
        int firstElem;
        int lastIdx = a.length - 1;

        while (count < d) {
            firstElem = a[0];
            for (int i = 0; i < lastIdx; i++) {
                a[i] = a[i + 1];
            }
            a[lastIdx] = firstElem;

            count++;
        }

        return a;
    }
    
    static int minimumBribes(int[] q) {
        int current = q.length;
        int n, temp, bribes;
        int totBribes = 0;
        
        while (current > 0) {
            n = current - 1;
            
            int index = n;
            while (current != q[index] && index >= 0) {
                index--;
            }
            
            bribes = 0;
            
            while (index < n) {
                temp = q[index];
                q[index] = q[index + 1];
                q[index + 1] = temp;
                
                bribes++;
                index++; 
                
                if (bribes > 2) {
                    return -1;
                }
            }
            
            current--;
            totBribes += bribes;
        }
        
        return totBribes;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };
        int res = hourglassSum(mat);
        if (res == -1) {
            System.out.println("Not possible");
        } else {
            System.out.println("Maximum sum of hour glass = " + res);
        }

        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotLeft(a, 4)));
        
        int[] b = {2, 1, 5, 3, 4};
        res = minimumBribes(b);
        if (res == -1) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(res);
        }
    }
}

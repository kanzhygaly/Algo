/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.algo;

/**
 *
 * @author YERLAN
 */
public class BairesDevTest {

    public static void main(String[] args) {

        System.out.println(isAlmostPalindrome("abba"));
        System.out.println(isAlmostPalindrome("abbc"));
        System.out.println(isAlmostPalindrome("abca"));

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 7};
        System.out.println(getMostPopularNuber(a));
    }

    private static double[] averageDistance(double x1, double y1, double x2, double y2, double x3, double y3) {
        double d1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double d2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double d3 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double w1 = (d2 * d3) / (d1 * d2 + d1 * d3 + d2 * d3);
        double w2 = (d1 * d3) / (d1 * d2 + d1 * d3 + d2 * d3);
        double w3 = (d1 * d2) / (d1 * d2 + d1 * d3 + d2 * d3);
        double[] points = {w1, w2, w3};
        return points;
    }

    private static boolean isAlmostPalindrome(String s) {
        boolean check = s.equals(new StringBuilder(s).reverse().toString());
        if (!check) {
            // try to modify
            System.out.println("Original: " + s);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, s.charAt(s.length() - 1 - i));
                    s = sb.toString();
                    check = s.equals(new StringBuilder(s).reverse().toString());
                    if (check) {
                        System.out.println("Modified: " + s);
                    }
                    break;
                }
            }
        }
        return check;
    }

    private static int getMostPopularNuber(int[] a) {
        int maxElementIndex = getArrayMaximumElementIndex(a);
        int[] b = new int[a[maxElementIndex] + 1];
        for (int i = 0; i < a.length; i++) {
            ++b[a[i]];
        }
        return getArrayMaximumElementIndex(b);
    }

    private static int getArrayMaximumElementIndex(int[] a) {
        int maxElementIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[maxElementIndex]) {
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }
}

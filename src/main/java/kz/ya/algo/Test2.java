package kz.ya.algo;

import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author YERLAN
 */
public class Test2 {

    public static void main(String[] args) {
        int[] A = new int[2];
        A[0] = 1;
        A[1] = 2;

        int[] B = new int[3];
        B[0] = 1;
        B[1] = 2;
        B[2] = 3;

        System.out.println(getMinimalValue(A, B));

        System.out.println(password("pAs66sWoR1d"));

        Calendar c = Calendar.getInstance();
        c.set(2018, 0, 31, 23, 59, 59);
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(c.getTime());

        c.set(2018, 0, 31, 23, 59, 59);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(c.getTime());
        
    }

    public static int getMinimalValue(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i]) {
                return A[k];
            }
        }
        return -1;
    }

    public static int password(String S) {
        if (S == null || S.isEmpty() || S.length() > 200) {
            return -1;
        }
        boolean hasUppercase = !S.equals(S.toLowerCase());
        if (!hasUppercase) {
            return -1;
        }
        boolean isAlphanumeric = S.matches("[A-Za-z0-9 ]*");
        if (!isAlphanumeric) {
            return -1;
        }

        int start = 0;
        int maxSize = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter((S.charAt(i)))) {
                String temp = S.substring(start, i + 1);
                if (!temp.equals(temp.toLowerCase())) {
                    // if string contains letter in uppercase, then string is valid
                    if (temp.length() > maxSize) {
                        maxSize = temp.length();
                    }
                }
            } else if (Character.isDigit((S.charAt(i)))) {
                start = i + 1;
            }
        }
        if (maxSize != 0) {
            return maxSize;
        }
        return -1;
    }
}

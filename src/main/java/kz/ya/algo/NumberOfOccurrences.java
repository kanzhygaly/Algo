package kz.ya.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author yerlana
 */
public class NumberOfOccurrences {

    public static void main(String args[]) {
        Integer ar[] = {3, 2, 1, 3};

        int c = countBS(ar.length, ar);
        System.out.println("Binary search: " + c);

        Integer arr[] = {6, 4, 1, 4, 3, 2, 5, 2, 1};
        c = findOccurrencesUnsorted(arr.length, arr);
        System.out.println("HashMap: " + c);
    }

    static int countBS(int n, Integer[] ar) {
        Arrays.sort(ar, Collections.reverseOrder());
        int maxi = ar[0];

        // get the index of last occurrence in array
        int j = last(ar, 0, n - 1, maxi, n);

        // return count
        return j + 1;
    }

    static int last(Integer arr[], int low, int high, int x, int n) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((mid == n - 1 || x > arr[mid + 1]) && arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                return last(arr, low, (mid - 1), x, n);
            } else {
                return last(arr, (mid + 1), high, x, n);
            }
        }
        return 0;
    }

    static int findOccurrencesUnsorted(int n, Integer[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(ar[i]) == null) {
                map.put(ar[i], 1);
            } else {
                int count = map.get(ar[i]);
                count++;
                map.remove(ar[i]);
                map.put(ar[i], count);
            }
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            if (key > max) {
                max = key;
            }
        }
        return map.get(max);
    }
}

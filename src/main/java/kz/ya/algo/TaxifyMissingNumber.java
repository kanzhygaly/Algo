/**
 * You have a sorted array of integers from 1 to n of the length n - 1.
 * Each number occurs exactly once but one number is missing.
 * Write a function that accepts an array and returns the missing number.
 *
 * Example:
 * Array: [1, 3, 4, 5, 6]
 * Result: 2
 */
package kz.ya.algo;

/**
 *
 * @author yerlana
 */
public class TaxifyMissingNumber {

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6};
        //System.out.println(findMissingNumber(arr));

        //System.out.println(findMissingNumberFast(arr, 0));
        int arr2[] = {1, 2, 3, 4, 6};
        //System.out.println(findMissingNumber(arr2));

        //System.out.println(findMissingNumberFast(arr2, 0));
//        System.out.println(findMissingNumberLog(arr));
        System.out.println(runBinarySearchIteratively(arr));
        System.out.println(runBinarySearchIteratively(arr2));
    }

    static int findMissingNumber(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return arr[i] + 1;
            }
        }
        return 0;
    }

    // recursively
    static int findMissingNumberFast(int arr[], int pos) {
        if (arr.length == 0) {
            return 0;
        }
        if (pos == arr.length - 1) {
            return 0;
        }
        if (arr[pos] + 1 != arr[pos + 1]) {
            return arr[pos] + 1;
        }

        return findMissingNumberFast(arr, pos + 1);
    }

    static int findMissingNumberLog(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        int mid = arr.length / 2;

        while (mid > 0) {
            if (arr[mid] - 1 != arr[mid - 1]) {
                return arr[mid] - 1;
            }
            mid--;
        }
        while (mid < arr.length - 1) {
            if (arr[mid] + 1 != arr[mid + 1]) {
                return arr[mid] + 1;
            }
            mid++;
        }
        return 0;
    }

    /**
     * // O(logN) In a binary search fashion, check for a mismatch between the
     * difference in the indices and array values. A mismatch tells us which
     * half a missing element is in. If there is a mismatch in the first half,
     * move left, otherwise move right. Do this until you have two candidate
     * elements left to consider.
     */
    static int runBinarySearchIteratively(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        // If all elements are present, then return 0.    
        if (right - left == arr[right] - arr[left]) {
            return 0;
        }

        // While 2 or more elements left to consider...
        while (right - left >= 2) {
            int mid = (left + right) / 2;
            if (mid - left != arr[mid] - arr[left]) {
                // Explore left-hand side
                right = mid;
            } else {
                // Explore right-hand side
                left = mid + 1;
            }
        }

        // Return missing value from the two candidates remaining...
//        return left == arr[left] - arr[0] ? right + arr[0] : left + arr[0];
        return arr[left] + 1; // or arr[right]-1
    }
}

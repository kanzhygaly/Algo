/**
 * Write an algorithm which reverses the letters in words, like:
 * Input: I love Taxify
 * Output:I evol yfixaT
 * Input is character array (not string) and output should also be character array.
 * Function needs to work in-place, modify the input array itself. Don't use any extra arrays,
 * string objects or language provider libraries. Use of temporary variables is allowed.
 * Example in Java:
 * Input: char[] input = ['I', ' ', 'l','o','v','e',' ','T','a','x','i','f','y'];
 * public static char[] reverseWords(char [] input) {
 * return input;
 * }
 * Output: ['I', ' ', 'e','v','o','l',' ','y','f','i','x','a','T'];
 * Example is in Java, but choice of programming language is free. Please write 
 * the code in the web browser, don't test or run it in your IDE.
 * Extra: you will earn extra points if you write unit tests for this function.
 */
package kz.ya.algo;

/**
 *
 * @author yerlana
 */
public class TaxifyReverse {

    public static void main(String[] args) {
        char[] input = {'I', ' ', 'l', 'o', 'v', 'e', ' ', 'T', 'a', 'x', 'i', 'f', 'y'};
        System.out.println(reverseWords(input));
    }
    
    public static char[] reverseWords(char[] input) {
        int left = 0;
        int mid = 1;
        int right;

        while (left < (input.length - 1)) {
            if (input[left] == ' ') {
                left++;
                mid++;
                continue;
            }

            // reach the end of the word
            while (mid < input.length && input[mid] != ' ') {
                mid++;
            }

            // if 1-character word, then skip
            if (mid - left < 2) {
                left = ++mid;
                continue;
            }

            // word reverse
            right = mid - 1;
            while (left < right) {
                char temp = input[left];
                input[left] = input[right];
                input[right] = temp;

                left++;
                right--;
            }

            left = ++mid;
        }
        return input;
    }
}

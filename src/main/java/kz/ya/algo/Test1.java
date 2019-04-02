package kz.ya.algo;

import java.util.ArrayList;

/**
 *
 * @author YERLAN
 */
public class Test1 {

    public static void main(String[] args) {

        int max = 1000;
        int sum = 0;
        for (int i = 1; i < max; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("");
        System.out.println("Sum: " + sum);

        System.out.println("");
        max = 4000000;
        sum = 0;
        int number = 0;
        int count = 1;
        while (number < max) {
            number = fibonacciRecusion(count);
            System.out.print(number + " ");
            if (number % 2 == 0) {
                sum += number;
            }
            count++;
        }
        System.out.println("");
        System.out.println("Sum: " + sum);

        System.out.println("");
        System.out.println("Primefactors of 600851475143");
        for (Long num : primeFactors(600851475143l)) {
            System.out.print(num + " ");
        }
        System.out.println("");

        System.out.println("");
        max = 91 * 99;
        for (int i = 900; i < 1000; i++) {
            for (int j = 900; j < 1000; j++) {
                number = i * j;
                if (isPalindrome(number) && number > max) {
                    max = number;
                    System.out.print(i + "*" + j + "=" + number + " ");
                }
            }
        }
        System.out.println("");
        System.out.println(max);

        System.out.println("");
        int min = 900000000;
        for (int i = 100000000; i < 900000000; i++) {
            if (isEvenlyDivisibleFrom1To20(i)) {
                System.out.print(i + " ");
                if (i < min)
                    min = i;
            }
        }
        System.out.println("");
        System.out.println(min);
    }

    public static int fibonacciRecusion(int number) {
        if (number <= 2) {
            return number;
        }
        return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2);
    }

    public static ArrayList<Long> primeFactors(long numbers) {
        long n = numbers;
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static boolean isPalindrome(int number) {
        int palindrome = number;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return true;
        }
        return false;
    }

    public static boolean isEvenlyDivisibleFrom1To20(int number) {
        boolean flag = true;
        for (int i = 1; i < 20; i++) {
            if (number % i != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

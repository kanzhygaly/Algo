package kz.ya.algo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YERLAN
 */
public class JavaApplication1 {

    public static void main(String[] args) {
        
        String name = "Yerlan  Akhmetov";
        System.out.println(name);
        System.out.println(name.trim().replaceAll(" +", " "));
        
        BigDecimal paymentAmount = new BigDecimal("200000").divide(new BigDecimal("1.809"), 10, BigDecimal.ROUND_HALF_UP);
        System.out.println(paymentAmount);
        BigDecimal exDiff = paymentAmount.multiply(new BigDecimal("0.809"));
        System.out.println(exDiff);
        System.out.println(exDiff.setScale(0, RoundingMode.HALF_UP));
        System.out.println(paymentAmount.setScale(0, RoundingMode.HALF_UP));
        
        System.out.println(getPhoneNumber("00-44  48 5555 8361"));
        System.out.println(getPhoneNumber("0 - 22 1985--324"));
        System.out.println(getPhoneNumber("555372654"));
        System.out.println(zip(1234, 0));

//        System.out.println(reverse("hello"));
//        System.out.println(reverseRecursive("hello"));
//        System.out.println(getEvenNumbers(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})));
//        System.out.println(sumOfDigits(987));
        fib(5);

        List<String> horses = new ArrayList<String>();
        horses.add(new String());
        List<? extends Object> animals = horses;
        Object obj = animals.get(0);                
    }

    public static String getPhoneNumber(String S) {
        String phoneNumber = S.replaceAll("\\D", "");
        int n = (int) Math.ceil((double) phoneNumber.length() / 3);
        String result = "";
        int chunkLen = 3, start, end;
        for (int i = 0; i < n; i++) {
            if (phoneNumber.length() - i * 3 == 2 || phoneNumber.length() - i * 3 == 4) {
                chunkLen = 2;
            }
            start = Math.min(phoneNumber.length() - chunkLen, i * 3);
            end = Math.min(phoneNumber.length(), start + chunkLen);
            result += phoneNumber.substring(start, end);
            if (i < n - 1) {
                result += "-";
            }
        }
        return result;
    }

    public static int zip(int A, int B) {
        if (A < 0 || A > 100000000) {
            return -1;
        }
        if (B < 0 || B > 100000000) {
            return -1;
        }

        int reverseA = reverse(A);
        int reverseB = reverse(B);

        boolean AisZero = A == 0;
        boolean BisZero = B == 0;

        int result = 0;
        while (A > 0 || B > 0) {
            if (A > 0) {
                result = result * 10 + reverseA % 10;
                reverseA /= 10;
                A /= 10;
            } else if (AisZero && A == 0) {
                result = result * 10;
                AisZero = false;
            }
            if (B > 0) {
                result = result * 10 + reverseB % 10;
                reverseB /= 10;
                B /= 10;
            } else if (BisZero && B == 0) {
                result = result * 10;
                BisZero = false;
            }
        }

        if (result > 100000000) {
            return -1;
        }
        return result;
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static String reverse(String str) {
        char[] result = new char[str.length()];
        int counter = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            result[counter++] = str.charAt(i);
        }
        return String.valueOf(result);
    }

    public static String reverseRecursive(String str) {
        return str.length() > 1 ? str.charAt(str.length() - 1) + reverseRecursive(str.substring(0, str.length() - 1)) : str;
    }

    public static List<Integer> getEvenNumbers(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (list.get(0) % 2 == 0) {
            result.add(list.get(0));
        }
        result.addAll(getEvenNumbers(list.subList(1, list.size())));
        return result;
    }

    public static int sumOfDigits(int num) {
        return num < 10 ? num : num % 10 + sumOfDigits(num / 10);
    }

    public static void fib(int n) {
        int a = 0, b = 1, next;
        for (int i = 0; i < n; i++) {
            next = a + b;
            a = b;
            b = next;
            System.out.print(b + " ");
        }
    }

}

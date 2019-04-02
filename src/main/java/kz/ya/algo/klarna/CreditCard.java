package kz.ya.algo.klarna;

/**
 *
 * @author yerlana
 */
public class CreditCard {

    public static void main(String[] args) {
        System.out.println(maskify(""));
        System.out.println(maskify("Skippy"));
        System.out.println(maskify("12345"));
        System.out.println(maskify("ABCD-EFGH-IJKLM-NOPQ"));
        System.out.println(maskify("4556364607935616"));
        System.out.println(maskify("4556-3646-0793-5616"));
        System.out.println(maskify("64607935616"));
        System.out.println(maskify("A1234567BCDEFG89HI"));
    }

    public static String maskify(String creditCardNumber) {
        if (creditCardNumber.isEmpty() // check for emtiness
                || creditCardNumber.length() < 6 // check if less than 6 chars
                || !creditCardNumber.matches(".*\\d+.*") // check if non-digit
                ) {
            return creditCardNumber; // no masking
        }

        StringBuilder sb = new StringBuilder();
        sb.append(creditCardNumber.charAt(0)); // append first char, no masking for it

        int N = creditCardNumber.length() - 5; // size of loop, to skip last 5 chars
        
        // if last 5 chars contains only lettter and numbers
        // then change size of loop to skip last 4 chars
        if (creditCardNumber.substring(N).matches(".*[0-9a-zA-Z].*")) {
            N += 1;
        }

        for (int i = 1; i < N; i++) {
            if (Character.isDigit(creditCardNumber.charAt(i))) { // only digits can be maskified
                sb.append("#");
                continue;
            }
            sb.append(creditCardNumber.charAt(i)); // no masking, append as it is
        }
        
        sb.append(creditCardNumber.substring(N)); // append last skipped chars

        return sb.toString();
    }
}

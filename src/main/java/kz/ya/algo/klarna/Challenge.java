package kz.ya.algo.klarna;

/**
 *
 * @author yerlana
 */
public class Challenge {

    public static void main(String[] args) {
        System.out.println(numberToOrdinal(0));
        System.out.println(numberToOrdinal(1));
        System.out.println(numberToOrdinal(2));
        System.out.println(numberToOrdinal(3));
        System.out.println(numberToOrdinal(4));
        System.out.println(numberToOrdinal(11));
        System.out.println(numberToOrdinal(12));
        System.out.println(numberToOrdinal(13));
        System.out.println(numberToOrdinal(21));
        System.out.println(numberToOrdinal(111));
        System.out.println(numberToOrdinal(212));
        System.out.println(numberToOrdinal(313));
        System.out.println(numberToOrdinal(1013));
    }

    public static String numberToOrdinal(Integer number) {
        if (number < 1 || number > 10000) { // numbers to be skipped
            return number.toString();
        }
        
        int mod100 = number % 100;
        int mod10 = number % 10;
        
        if (mod10 == 1 && mod100 != 11) {
            // if number doesn't ends with 11
            return number + "st";
        } else if (mod10 == 2 && mod100 != 12) {
            // if number doesn't ends with 12
            return number + "nd";
        } else if (mod10 == 3 && mod100 != 13) {
            // if number doesn't ends with 13
            return number + "rd";
        }
        
        // all other
        return number + "th";
    }
}

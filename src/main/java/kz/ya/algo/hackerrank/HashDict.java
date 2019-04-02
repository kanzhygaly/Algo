package kz.ya.algo.hackerrank;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author yerlana
 */
public class HashDict {

    static void checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) {
            System.out.println("No");
        } else {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String word : magazine) {
                Integer count = hashMap.get(word);
                if (count == null) {
                    hashMap.put(word, 1);
                } else {
                    hashMap.put(word, count + 1);
                }
            }
            String result = "Yes";
            for (String word : note) {
                Integer count = hashMap.get(word);
                if (count == null) {
                    result = "No";
                    break;
                } else if (count == 1) {
                    hashMap.remove(word);
                } else {
                    hashMap.put(word, count - 1);
                }
            }
            System.out.println(result);
        }
    }

    static String twoStrings(String s1, String s2) {
        HashSet<Character> hashSet = new HashSet<>();
        for (Character c : s1.toCharArray()) {
            hashSet.add(c);
        }
        for (Character c : s2.toCharArray()) {
            if (hashSet.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String[] mag = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};
        checkMagazine(mag, note);
        String[] mag1 = {"two", "times", "three", "is", "not", "four"};
        String[] note1 = {"two", "times", "two", "is", "four"};
        checkMagazine(mag1, note1);
        
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}

package kz.ya.algo;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author yerlana
 */
public class Keywords {

    public static void main(String args[]) {
        String text = "why how what how when how when what";
        ArrayList<String> keys = new ArrayList<>();
        keys.add("what");
        keys.add("when");

        int c = minimumLength(text, keys);
        System.out.println(c);

        text = "why how whywhat why what how what when what";
        keys.clear();
        keys.add("why");
        keys.add("how");
        keys.add("what");

        c = minimumLength(text, keys);
        System.out.println(c);
    }

//    static int minimumLength(String text, ArrayList<String> keys) {
//        StringTokenizer tokenizer = new StringTokenizer(text);
//        ArrayList<String> dup = new ArrayList<>(keys);
//
//        int counter = 0;
//        String word;
//        int length = -1;
//        StringBuilder sb = new StringBuilder();
//
//        while (tokenizer.hasMoreTokens()) {
//            if (counter == keys.size() && !dup.isEmpty()) {
//                dup = new ArrayList<>(keys);
//            } else if (counter == keys.size() && dup.isEmpty()) {
//                for (String s : keys) {
//                    sb.append(s);
//                }
//                length = sb.length() + (keys.size() - 1);
//                break;
//            }
//            word = tokenizer.nextToken();
//            if (dup.contains(word)) {
//                dup.remove(word);
//                counter++;
//            }
//        }
//        return length;
//    }
    static int minimumLength(String text, ArrayList<String> keys) {
        StringTokenizer tokenizer = new StringTokenizer(text);

        StringBuilder keyLine = new StringBuilder();
        for (String s : keys) {
            keyLine.append(s);
        }
        StringBuilder dup = new StringBuilder(keyLine);

        int counter = 0;
        String word;
        int length = -1;
        int i;

        while (tokenizer.hasMoreTokens()) {
            if (counter == keys.size() && dup.length() > 0) {
                dup = new StringBuilder(keyLine);
            } else if (counter == keys.size() && dup.length() == 0) {
                length = keyLine.length() + (keys.size() - 1);
                break;
            }
            word = tokenizer.nextToken();
            i = dup.indexOf(word);
            if (i != -1) {
                dup.delete(i, i + word.length());
                counter++;
            }
        }
        return length;
    }
}

package kz.ya.algo.vmware;

/**
 *
 * @author yerlana
 */
public class MergedStrings {

    private static String mergeStrings(String a, String b) {
        int N = a.length() < b.length() ? a.length() : b.length();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        
        if (a.length() - N > 0) {
            sb.append(a.substring(N));
        } else if (b.length() - N > 0) {
            sb.append(b.substring(N));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        System.out.println(mergeStrings(a, b));
    }
}

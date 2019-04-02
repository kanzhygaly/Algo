package kz.ya.algo.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author yerlana
 */
public class Assignment21 {
    
    public static void main(String[] args) {
        // codeList=[[apple,apple],[banana,anything,banana]]
        List<List<String>> codeList = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("apple");
        item.add("apple");
        codeList.add(item);
        item = new ArrayList<>();
        item.add("banana");
        item.add("anything");
        item.add("banana");
        codeList.add(item);
        
        // shoppingCart=[apple,apple,orange,apple,banana,orange,banana,orange]
        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        
        int n = checkWinner(codeList, shoppingCart);
        System.out.println(n);
    }

    public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList.isEmpty()) {
            return 1;
        }
        // collect all codes in one queue
        LinkedList<String> codeLine = new LinkedList<>(codeList.get(0));
        for (int i = 1; i < codeList.size(); i++) {
            codeLine.addAll(codeList.get(i));
        }

        // get first code
        String code = codeLine.peek();

        for (String fruit : shoppingCart) {
            if (code.equals("anything") || fruit.equals(code)) {
                codeLine.poll(); // remove code from line
                if (codeLine.isEmpty()) {
                    // if line is empty return success
                    return 1;
                }
                // get next code
                code = codeLine.peek();
            }
        }
        return codeLine.isEmpty() ? 1 : 0;
    }
}

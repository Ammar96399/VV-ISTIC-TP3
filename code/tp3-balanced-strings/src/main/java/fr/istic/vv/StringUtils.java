package fr.istic.vv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        List<Character> stack = new ArrayList<>();
        if (Objects.nonNull(str)) {
            if (str.equals("")) {
                return true;
            } else if (str.length() < 2) {
                return false;
            } else {
                for (var i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                        stack.add(0, str.charAt(i));
                    }
                    if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
                        if (stack.isEmpty()) {
                            return false;
                        } else {
                            char last = stack.remove(0);
                            if (str.charAt(i) != last) {
                                return false;
                            }
                        }
                    }
                }
                return stack.isEmpty();
            }
        } else {
            return false;
        }
    }
}

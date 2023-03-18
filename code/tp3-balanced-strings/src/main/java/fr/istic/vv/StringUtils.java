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
            } else {
                for (var i = 0; i < str.length(); i++) {
                    if (List.of('{', '[', '(').contains(str.charAt(i))) {
                        stack.add(0, str.charAt(i));
                    } else if (List.of('}', ']', ')').contains(str.charAt(i))) {
                        char last = stack.remove(0);
                        switch (last) {
                            case '{':
                                if (str.charAt(i) == '}')
                                    break;
                            case '[':
                                if (str.charAt(i) == ']')
                                    break;
                            case '(':
                                if (str.charAt(i) == ')')
                                    break;
                            default:
                                return false;
                        }
                    } else {
                        return false;
                    }
                }
                return stack.isEmpty();
            }
        } else {
            return false;
        }
    }
}

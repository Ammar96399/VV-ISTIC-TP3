package fr.istic.vv;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        if (Objects.nonNull(str)) {
            if (str.equals("")) {
                return true;
            } else if (str.length() < 2) {
                return false;
            } else if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}'
                    || str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']'
                    || str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
                return StringUtils.isBalanced(str.substring(1, str.length() - 1));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

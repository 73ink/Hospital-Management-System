package Utils;

import java.time.LocalDate;
import java.util.UUID;

public class HelperUtils {

    // Null Check Methods
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // String Validation Methods
    public static boolean isValidString(String str) {
        return isNotNull(str);
    }

    public static boolean isValidString(String str, int minLength) {
        return isNotNull(str) && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isNotNull(str) && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return isNotNull(str) && str.matches(regex);
    }

    // ID Generation Methods
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    public static String generateId(String prefix, int length) {
        String random = UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
        return prefix + "-" + random;
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase() + "-" + suffix;
    }

}
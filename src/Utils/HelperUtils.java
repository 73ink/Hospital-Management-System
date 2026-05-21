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

    // Date Validation Methods
    public static boolean isValidDate(LocalDate date) {
        return date != null;
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidDate(LocalDate date, LocalDate minDate, LocalDate maxDate) {
        return date != null &&
                (date.isEqual(minDate) || date.isAfter(minDate)) &&
                (date.isEqual(maxDate) || date.isBefore(maxDate));
    }

    public static boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }

    public static boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    public static boolean isToday(LocalDate date) {
        return date != null && date.isEqual(LocalDate.now());
    }

    // Numeric Validation Methods
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }

    public static boolean isZero(int num) {
        return num == 0;
    }

    public static boolean isZero(double num) {
        return num == 0;
    }

    // Input Validation Methods
    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }

        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return isValidAge(age);
    }

    public static boolean isValidPhone(String phone) {
        return isNotNull(phone) && phone.length() >= 8;
    }

    public static boolean isValidEmail(String email) {
        return isNotNull(email) && email.contains("@");
    }

    public static boolean isValidBloodGroup(String bloodGroup) {
        return isNotNull(bloodGroup);
    }

    public static boolean isValidGender(String gender) {
        return isNotNull(gender);
    }

    public static boolean isValidShift(String shift) {
        return shift.equalsIgnoreCase("Morning") ||
                shift.equalsIgnoreCase("Evening") ||
                shift.equalsIgnoreCase("Night");
    }

    public static boolean isValidAppointmentStatus(String status) {
        return status.equalsIgnoreCase("Scheduled") ||
                status.equalsIgnoreCase("Completed") ||
                status.equalsIgnoreCase("Cancelled") ||
                status.equalsIgnoreCase("Rescheduled");
    }

    public static boolean isValidTriageLevel(int level) {
        return level >= 1 && level <= 5;
    }

    public static boolean isValidFee(double fee) {
        return fee >= 0;
    }

    public static boolean isValidBedNumber(String bedNumber) {
        return isNotNull(bedNumber);
    }

    public static boolean isValidRoomNumber(String roomNumber) {
        return isNotNull(roomNumber);
    }

    public static boolean isValidDepartmentName(String departmentName) {
        return isValidString(departmentName, 2);
    }

    public static boolean isValidChoice(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }
}
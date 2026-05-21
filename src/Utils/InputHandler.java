package Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    private Scanner input;

    public InputHandler() {
        input = new Scanner(System.in);
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(input.nextLine());
                return value;
            } catch (Exception e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public int getIntInput(String prompt, int min, int max) {
        while (true) {
            int value = getIntInput(prompt);

            if (HelperUtils.isValidNumber(value, min, max)) {
                return value;
            }

            System.out.println("Please enter a number between " + min + " and " + max);
        }
    }

    public double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(input.nextLine());
                return value;
            } catch (Exception e) {
                System.out.println("Invalid decimal number. Please try again.");
            }
        }
    }

    public LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " yyyy-mm-dd: ");
                return LocalDate.parse(input.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Example: 2026-05-21");
            }
        }
    }

    public boolean getConfirmation(String prompt) {
        System.out.print(prompt + " yes/no: ");
        String answer = input.nextLine();
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }
}
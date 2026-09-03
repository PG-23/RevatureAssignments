/*
Week 2 Challenge - Password Validator
By Patrick Guinn
9/3/26
 */

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Welcome to my Password Validator"
                + "\n\tPassword Requirements:"
                + "\n\t\tBe at least 8 characters"
                + "\n\t\tContain at least one uppercase letter"
                + "\n\t\tContain at least one lowercase letter"
                + "\n\t\tContain at least one number"
                + "\n\nPlease enter a password: ");

        String password = kbd.nextLine();

        boolean valid, minLen, minUpper, minLower, minNum;
        valid = minLen = minUpper = minLower = minNum = false;

        if (password.length() >= 8) {
            minLen = true;
        }
        if (password.matches(".*[A-Z].*")){
            minUpper = true;
        }
        if (password.matches(".*[a-z].*")) {
            minLower = true;
        }
        if (password.matches(".*\\d.*")) {
            minNum = true;
        }

        if (minLen && minUpper && minLower && minNum) {
            valid = true;
        }

        if (valid) {
            System.out.println("Password accepted!");
        } else {
            System.out.println("Password rejected:");
            if (!minLen){
                System.out.println("- Must be at least 8 characters");
            }
            if (!minUpper){
                System.out.println("- Must contain an uppercase letter");
            }
            if (!minLower){
                System.out.println("- Must contain a lowercase letter");
            }
            if (!minNum){
                System.out.println("- Must contain a number");
            }
        }
    }
}

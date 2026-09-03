/*
Week 2 Challenge - REPL w/ Banking transactions
By Patrick Guinn
 */

import java.util.Scanner;

public class REPLBanking {
    public static void main(String[] args) {
        System.out.println("\nREPL Challenge");

        double balance = 0.0;
        int input;
        Scanner kbd = new Scanner(System.in);

        do {
            System.out.println("\nPlease select an option below:");
            System.out.println( "1. Check Balance\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Exit\n");

            input = Integer.parseInt(kbd.nextLine());
            double amt;
            switch (input) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", balance);
                    break;
                case 2:
                    System.out.println("Please enter a deposit amount:");
                    amt = Double.parseDouble(kbd.nextLine());
                    balance += amt;
                    System.out.printf("Transaction successful - You have deposited $%.2f%n", amt);
                    break;
                case 3:
                    System.out.println("Please enter a withdrawal amount:");
                    amt = Double.parseDouble(kbd.nextLine());
                    if (balance - amt < 0) {
                        System.out.println("Transaction failed - Insufficient funds");
                    } else {
                        balance -= amt;
                        System.out.printf("Transaction successful - You have withdraw $%.2f%n", amt);
                    }
                    break;
                case 4:
                    System.out.println("You are now exiting the menu");
                    break;
            }
        } while (input != 4);
        kbd.close();
    }
}

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RevatureChallenges {
    public static void main(String[] args) {
        // Week 2 Challenge - Hello World
        System.out.println("Hello World!");

        // Week 2 Challenge - Printing Output
        int age = 18;
        double ht = 6.0;
        String name = "Patrick";

        System.out.printf("Name: %s, Age: %d, Height: %.1f%n", name, age, ht);

        // Week 2 Challenge - Operators
        int a = 20;
        int b = 10;

        int addTotal = a + b;
        int subtractTotal = a - b;
        int multTotal = a * b;
        int divTotal = a / b;

        boolean isALarger;
        if (a > b) {
            isALarger = true;
        } else {
            isALarger = false;
        }

        boolean result;
        if (a > b && b > 0) {
            result = true;
        } else {
            result = false;
        }

        System.out.printf("Addition: %d%nSubtraction: %d%nMultiplication: " +
                        "%d%nDivision: %d%nResult 1: %B%nResult 2: %B%n", addTotal,
                subtractTotal, multTotal, divTotal, isALarger, result);


        // Week 2 Challenge - Control Flow
        int score = 75;
        char grade = 'B';

        if (score >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 75) {
            grade = 'B';
        } else if (score >= 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        System.out.println("Grade: " + grade);

        // Week 2 Challenge - Loops
        System.out.print("For Loop: ");
        for (int i = 1; i <= 5; i++) {
            if (i < 5) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
        }

        System.out.print("\nWhile Loop: ");
        int i = 0;
        while (i++ < 5) {
            if (i < 5) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
        }

        System.out.print("\nDo-While Loop: ");
        i = 1;
        do {
            if (i < 5) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
            i++;
        } while (i <= 5);

        // Week 2 Challenge - Calculator
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";
        double calcResult = 0.0;

        while (again == "y") {
            switch (operator) {
                case '+':
                    calcResult = num1 + num2;
                    break;
                case '-':
                    calcResult = num1 - num2;
                    break;
                case '*':
                    calcResult = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error cannot divide by zero");
                    } else {
                        calcResult = num1 / num2;
                    }
                    break;
            }
            System.out.println("\nResult: " + calcResult);
            again = "n";
        }
        System.out.println("Thank you for using the calculator.");

        // Week 2 Challenge - Calculate 5 Test Scores
        // Please note this challenge does not have any error handling
        // and test scores must be input as space separated values on
        // the same line
        System.out.println("\nCalculate 5 Test Scores Challenge"
                + "\nPlease enter 5 test scores: ");

        Scanner kbd = new Scanner(System.in);
        int numScores = 5;
        Integer[] scores = new Integer[numScores];

        for (i = 0; i < numScores; i++) {
            scores[i] = kbd.nextInt();
        }
        kbd.nextLine();
        int totalScore = 0;
        int maxScore = scores[0];
        int minScore = scores[0];

        for (Integer s: scores) {
            totalScore += s;
            if (s > maxScore) {
                maxScore = s;
            }
            if (s < minScore) {
                minScore = s;
            }
        }

        int avgScore = totalScore / numScores;
        System.out.printf("Total: %d%nAverage: %d%nHighest: %d%nLowest: %d%n",
                totalScore, avgScore, maxScore, minScore);

        System.out.println("Your values were:");
        for (Integer s: scores) {
            if (s >= 90) {
                grade = 'A';
            } else if (s >= 80) {
                grade = 'B';
            } else if (s >= 70) {
                grade = 'C';
            } else if (s >= 60){
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println(s + " - " + grade);
        }

        // Week 2 Challenge - REPL
        System.out.println("\nREPL Challenge");
        double balance = 0.0;
        int input;
        kbd = new Scanner(System.in);
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
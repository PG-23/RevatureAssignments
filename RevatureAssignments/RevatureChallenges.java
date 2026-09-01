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
    }
}
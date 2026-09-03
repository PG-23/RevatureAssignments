/*
Week 2 Challenge - Calculator
By Patrick Guinn
 */

public class Calculator {
    public static void main(String[] args) {
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

/*
Week 2 Challenge - Operators
By Patrick Guinn
 */

public class Operators {
    public static void main(String[] args) {
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
    }
}

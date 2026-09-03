/*
Week 2 Challenge - Loops
By Patrick Guinn
 */

public class Loops {
    public static void main(String[] args) {
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
    }
}

/*
Week 2 Challenge - Calculate 5 Test Scores
    Please note this challenge does not have any error handling
    and test scores must be input as space separated values on
    the same line
By Patrick Guinn
 */

import java.util.Scanner;

public class CalculateTestScores {
    public static void main(String[] args) {
        System.out.println("\nCalculate 5 Test Scores Challenge"
                + "\nPlease enter 5 test scores: ");

        Scanner kbd = new Scanner(System.in);
        int numScores = 5;
        Integer[] scores = new Integer[numScores];

        for (int i = 0; i < numScores; i++) {
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

        char grade;
        System.out.println("\nYour values were:");
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
        kbd.close();
    }
}

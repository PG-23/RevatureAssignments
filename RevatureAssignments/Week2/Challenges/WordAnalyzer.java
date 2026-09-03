/*
Week 2 Challenge - Word Analyzer
By Patrick Guinn
9/3/26
 */

import java.util.Locale;
import java.util.Scanner;

public class WordAnalyzer {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Welcome to my Word Analyzer!"
                        + "\n\nPlease enter a word:");

        String word = kbd.nextLine();

        int numChars = word.length();
        int numVowels, numConsonants, numDigits, numSpaces;
        numVowels = numConsonants = numDigits = numSpaces = 0;

        String lowerWord = word.toLowerCase();
        for (int i = 0; i < lowerWord.length(); i++) {
            char c = lowerWord.charAt(i);
            if (c >= 'a' && c <= 'z') {
                switch (c) {
                    case 'a', 'e', 'i', 'o', 'u' -> numVowels++;
                    default -> numConsonants++;
                }
            } else if (Character.isDigit(c)) {
                numDigits++;
            } else if (Character.isWhitespace(c)) {
                numSpaces++;
            }
        }

        System.out.println("Characters: " + numChars
                        + "\nVowels: " + numVowels
                        + "\nConsonants: " + numConsonants
                        + "\nDigits: " + numDigits
                        + "\nSpaces: " + numSpaces);
    }
}

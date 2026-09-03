/*
Week 2 Challenge - REPL App
By Patrick Guinn
9/3/26
 */

import java.util.Random;
import java.util.Scanner;

public class REPLApp {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String input = "";
        int a, b, result;
        int min, max, randNum;

        do {
            System.out.println("Welcome to my REPL App!" +
                                "\n(enter help to list commands)");
            input = kbd.nextLine().toLowerCase();

            switch (input) {
                case "help":
                    System.out.println("Available commands:"
                                    + "\n  add"
                                    + "\n  subtract"
                                    + "\n  multiply"
                                    + "\n  divide"
                                    + "\n  random"
                                    + "\n  reverse"
                                    + "\n  quit");
                    break;
                case "add":
                    System.out.println("First number: ");
                    a = Integer.parseInt(kbd.nextLine());
                    System.out.println("Second number: ");
                    b = Integer.parseInt(kbd.nextLine());
                    result = a + b;
                    System.out.println("Result: " + result);
                    break;
                case "subtract":
                    System.out.println("First number: ");
                    a = Integer.parseInt(kbd.nextLine());
                    System.out.println("Second number: ");
                    b = Integer.parseInt(kbd.nextLine());
                    result = a - b;
                    System.out.println("Result: " + result);
                    break;
                case "multiply":
                    System.out.println("First number: ");
                    a = Integer.parseInt(kbd.nextLine());
                    System.out.println("Second number: ");
                    b = Integer.parseInt(kbd.nextLine());
                    result = a * b;
                    System.out.println("Result: " + result);
                    break;
                case "divide":
                    System.out.println("First number: ");
                    a = Integer.parseInt(kbd.nextLine());
                    System.out.println("Second number: ");
                    b = Integer.parseInt(kbd.nextLine());
                    result = a / b;
                    System.out.println("Result: " + result);
                    break;
                case "random":
                    System.out.println("Minimum: ");
                    min = Integer.parseInt(kbd.nextLine());
                    System.out.println("Maximum: ");
                    max = Integer.parseInt(kbd.nextLine());
                    Random rand = new Random();
                    randNum = rand.nextInt((max - min) + 1) + min;
                    System.out.println("Random number: " + randNum);
                    break;
                case "reverse":
                    System.out.println("Enter text: ");
                    String word = kbd.nextLine();
                    String revWord = new StringBuilder(word).reverse().toString();
                    System.out.println(revWord);
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    break;
            }
        } while (!input.equals("quit"));
    }
}
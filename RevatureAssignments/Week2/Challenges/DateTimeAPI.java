/*
Week 2 Challenge - DateTime API
By Patrick Guinn
 */

import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.*;

public class DateTimeAPI {
    public static void main(String[] args) {
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Year: " + LocalDate.now().getYear());
        System.out.println("Month: " + LocalDate.now().getMonth());
        System.out.println("Day: " + LocalDate.now().getDayOfMonth());

        Scanner kbd = new Scanner(System.in);

        System.out.print("\n\nEnter your birth date: ");
        String input = kbd.nextLine();
        Period agePeriod = Period.between(LocalDate.parse(input), LocalDate.now());
        int age = agePeriod.getYears();
        System.out.printf("You are %d years old.", age);

        System.out.print("\n\nEnter your birthday: ");
        input = kbd.nextLine();
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = LocalDate.parse(input).withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long remDays = ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.printf("Days until your next birthday: %d", remDays);
        kbd.close();
    }
}

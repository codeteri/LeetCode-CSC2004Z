import java.util.Scanner;
import java.io.*;

public class Oddities {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename;

        // User inputs the file name of dates
        System.out.println("Enter the name of the text file of dates:");
        filename = scanner.nextLine();

        // Open the input file
        File myFile = new File(filename);

        try {
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split("/");

                // Extract day, month, and year from the input
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                // Check if the date consists of only odd digits
                boolean isOddDate = isOddDigitsOnly(day) && isOddDigitsOnly(month) && isOddDigitsOnly(year);

                if (isOddDate) {
                    System.out.println("The date " + line + " has all odd digits.");
                } else {
                    // Calculate the next date with all odd digits
                    String nextOddDate = findNextOddDate(day, month, year);
                    int daysUntilNextOddDate = daysUntilDate(day, month, year, nextOddDate);
                    System.out.println("The first date after " + line + " with all odd digits is " + nextOddDate + " which is " + daysUntilNextOddDate + " day" + (daysUntilNextOddDate == 1 ? "" : "s") + " later.");
                }
            }
            myReader.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("File Not Found");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    // Check if a number consists of only odd digits
    private static boolean isOddDigitsOnly(int number) {
        String str = Integer.toString(number);
        for (char c : str.toCharArray()) {
            if (c == '0' || c == '2' || c == '4' || c == '6' || c == '8') {
                return false;
            }
        }
        return true;
    }

    // Find the next date with all odd digits
    private static String findNextOddDate(int day, int month, int year) {
        while (true) {
            // Increment the day and adjust month/year if needed
            day++;
            if (day > daysInMonth(month, year)) {
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }

            // Check if the new date has all odd digits
            if (isOddDigitsOnly(day) && isOddDigitsOnly(month) && isOddDigitsOnly(year)) {
                return day + "/" + month + "/" + year;
            }
        }
    }

    // Calculate the number of days until a date
    private static int daysUntilDate(int startDay, int startMonth, int startYear, String endDate) {
        String[] parts = endDate.split("/");
        int endDay = Integer.parseInt(parts[0]);
        int endMonth = Integer.parseInt(parts[1]);
        int endYear = Integer.parseInt(parts[2]);

        int days = 0;
        while (startDay != endDay || startMonth != endMonth || startYear != endYear) {
            days++;
            startDay++;
            if (startDay > daysInMonth(startMonth, startYear)) {
                startDay = 1;
                startMonth++;
                if (startMonth > 12) {
                    startMonth = 1;
                    startYear++;
                }
            }
        }
        return days;
    }

    // Get the number of days in a month
    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    // Check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}

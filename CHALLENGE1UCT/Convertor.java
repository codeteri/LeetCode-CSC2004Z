import java.util.Scanner;

public class Convertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter a time or 'quit':");
        while (!(input = scanner.nextLine()).equals("quit")) {
            String[] timeParts = input.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            String description = convertTime(hour, minutes);
            System.out.println(description);

            System.out.println("Enter a time or 'quit':");
        }
        System.out.println("Done");
        scanner.close();
    }

    public static String convertTime(int hour, int minutes) {
        String[] hourNames = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
        String[] minuteNames = {"o'clock", "five", "ten", "quarter", "twenty", "twenty five", "half"};
    
        int roundedMinutes = Math.round(minutes / 5.0f) * 5;
    
        if (roundedMinutes == 0) {
            return hourNames[hour % 12] + " " + minuteNames[0];
        } else if (roundedMinutes <= 7 || roundedMinutes >= 53) {
            return "about " + hourNames[hour % 12] + " o'clock";
        } else if (roundedMinutes <= 30) {
            return "about " + minuteNames[roundedMinutes / 5] + " past " + hourNames[hour % 12];
        } else {
            return "about " + minuteNames[12 - (roundedMinutes / 5)] + " to " + hourNames[(hour + 1) % 12];
        }
    }
}
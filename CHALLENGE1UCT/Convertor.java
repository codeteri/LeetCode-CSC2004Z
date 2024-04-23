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
        String[] minuteNames = {"", "five", "ten", "quarter", "twenty", "twenty five", "half"};
    
        int roundedMinutes = Math.round(minutes / 5.0f) * 5;
        int nextHour = (hour + 1) % 12;
        if (nextHour == 0) nextHour = 12;
    
        String timeDescription = "";
    
        if (roundedMinutes == 0) {
            timeDescription = (hour == 0 || hour == 12) ? "about twelve o'clock" : "about " + hourNames[hour % 12] + " o'clock";
        } else if (roundedMinutes <= 30) {
            timeDescription = "about " + minuteNames[roundedMinutes / 5] + (roundedMinutes == 15 || roundedMinutes == 30 ? "" : " past ") + hourNames[hour % 12];
        } else {
            roundedMinutes = 60 - roundedMinutes;
            timeDescription = "about " + minuteNames[roundedMinutes / 5] + (roundedMinutes == 15 ? "" : " to ") + hourNames[nextHour];
        }
    
        return timeDescription;
    }
}

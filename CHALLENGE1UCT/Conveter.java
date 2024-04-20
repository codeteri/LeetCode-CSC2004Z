package CHALLENGE1UCT;


import java.util.*;

class Converter {
  public static void main(String[] args){
    String[] hours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
    String[] minutes = {"o'clock", "five", "ten", "quarter", "twenty", "twenty five", "half", "twenty five", "twenty", "quarter", "ten", "five", "o'clock"};

    Scanner Obj = new Scanner(System.in);
    String time;

    do {
      System.out.println("Enter a time or 'quit':");
      time = Obj.nextLine();

      if (!time.equals("quit")) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        int minuteIndex = (minute + 2) / 5; // Round to the nearest 5
        if (minuteIndex > 6) {
          hour++; // Go to the next hour
          minuteIndex = 12 - minuteIndex; // Get the minutes to the next hour
        }

        String output = minutes[minuteIndex] + " " + (minuteIndex == 0 || minuteIndex == 12 ? "" : minuteIndex <= 6 ? "past " : "to ") + hours[hour % 12];
        System.out.println(minute % 5 == 0 ? output : "about " + output);
      }
    } while (!time.equals("quit"));

    System.out.println("Done");
    Obj.close();
  }
}
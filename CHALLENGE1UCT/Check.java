import java.util.*;
import java.io.*;

public class Check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.println("Enter the name of the cards file:");
        filename = scanner.nextLine();

        // Open the file and read each line and split the input into different classes
        File myFile = new File(filename);

        try {
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    Card[] cards = new Card[3];
                    for (int i = 0; i < 3; i++) {
                        String shape = parts[i].split(",")[0];
                        String colour = parts[i].split(",")[1];
                        String pattern = parts[i].split(",")[2];
                        cards[i] = new Card(shape, colour, pattern);
                    }

                    System.out.println("Processing: " + line);

                    // Check if all three cards are distinct or all three cards are the same
                    if (cards[0].equals(cards[1]) && cards[1].equals(cards[2]) && cards[0].equals(cards[2]) 
                    || (!cards[0].equals(cards[1]) && !cards[1].equals(cards[2]) && !cards[0].equals(cards[2]))) {
                    System.out.println("Valid");
                    } else {
                    System.out.println("Invalid");
                    }

                } else {
                    System.out.println("Invalid Input:" + line);
                }
            }
            myReader.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            // handle file not found exception
            System.out.println("File not found: " + filename);
            e.printStackTrace();
            System.exit(1); // Exit the program with an error code
        } finally {
            scanner.close(); // Close the scanner in a finally block to ensure it's always closed
        }
    }
}

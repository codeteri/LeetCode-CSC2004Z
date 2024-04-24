import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Order {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the word lists text file:");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");

                if (words.length == 1) {
                    System.out.println("Longest is 1.");
                    continue;
                }

                int longestSubsequenceLength = 1;
                int currentSubsequenceLength = 1;
                int solutionsCount = 1;

                for (int i = 1; i < words.length; i++) {
                    if (words[i].compareTo(words[i - 1]) >= 0) {
                        currentSubsequenceLength++;
                    } else {
                        if (currentSubsequenceLength > longestSubsequenceLength) {
                            longestSubsequenceLength = currentSubsequenceLength;
                            solutionsCount = 1;
                        } else if (currentSubsequenceLength == longestSubsequenceLength) {
                            solutionsCount++;
                        }
                        currentSubsequenceLength = 1;
                    }
                }

                if (currentSubsequenceLength > longestSubsequenceLength) {
                    longestSubsequenceLength = currentSubsequenceLength;
                    solutionsCount = 1;
                } else if (currentSubsequenceLength == longestSubsequenceLength) {
                    solutionsCount++;
                }

                if (solutionsCount > 1) {
                    System.out.println("Multiple solutions length " + longestSubsequenceLength + ".");
                } else {
                    System.out.println("Longest is " + longestSubsequenceLength + ".");
                }
            }

            fileScanner.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}

package CHALLENGE3UCT;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Double;

public class Ships {

  public static void main(String[] args){

    // Open the scanner and get the filename
    Scanner scanner = new Scanner(System.in);
    String filename;

    System.out.println("Enter the name of the ship data file:");
    filename = scanner.nextLine();
    
    try {
      //Processing(read from the file)
      File myFile = new File(filename);
      Scanner fileScanner = new Scanner(myFile);

      int counter = 0;
      while (fileScanner.hasNextLine()) {
        
        String line = fileScanner.nextLine();
        String[] partsS1 = line.split(" ");

        ShipDetails s1 = new ShipDetails(Double.parseDouble(partsS1[0]),Double.parseDouble(partsS1[1]),Double.parseDouble(partsS1[2]),Double.parseDouble(partsS1[3]),Double.parseDouble(partsS1[4]));

        String secondLine = fileScanner.nextLine();
        String[] partsS2 = secondLine.split(" ");

        ShipDetails s2 = new ShipDetails(Double.parseDouble(partsS2[0]),Double.parseDouble(partsS2[1]),Double.parseDouble(partsS2[2]),Double.parseDouble(partsS2[3]),Double.parseDouble(partsS2[4]));

        counter++;
        System.out.print("Pair "+counter+": Intersection point: "+ s1.intersect(s2) +"; ");


        String verdict = "";
        if (Math.abs(Math.round(s1.distance())-Math.round(s2.distance())) < 0.5) {
          verdict = "Tied.";
        } else if (Math.round(s1.distance())<Math.round(s2.distance())) {
          verdict = "Ship S1 is nearest.";
        } else if (Math.round(s1.distance())>Math.round(s2.distance())){
          verdict = "Ship S2 is nearest.";
        } else {
          verdict = "undefined";
        }

        System.out.println("Ship S1's distance is "+String.format("%.1f", s1.distance())+"; " +
        "Ship S2's distance is "+String.format("%.1f", s2.distance())+"; "+ verdict);
        
      }
      fileScanner.close();
      System.out.println("Done");
    } catch (FileNotFoundException e) {
      // handle exception
      System.out.println("File Not Found Sorry");
      e.printStackTrace();
      System.exit(1);
    }finally {
      scanner.close();
    }
    
  
  }
}


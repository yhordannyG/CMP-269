import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {

        File inputFile = new File("students.txt");
        File outputFile = new File("grades_report.txt");
        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                try {
                    String name = parts[0];
                    
                    double score1 = Double.parseDouble(parts[1]);
                    double score2 = Double.parseDouble(parts[2]);
                    double score3 = Double.parseDouble(parts[3]);
                    
                    double average = (score1 + score2 + score3) / 3.0;
                    writer.printf("Student: %s | Average: %.2f%n", name, average);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping invalid data: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        finally {
            System.out.println("Processing Complete");
        }
    }
}


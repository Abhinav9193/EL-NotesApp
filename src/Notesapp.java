import java.io.*;
import java.util.Scanner;

public class Notesapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write a Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNoteToFile(fileName, note);
                    break;

                case 2:
                    readNotesFromFile(fileName);
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void writeNoteToFile(String fileName, String note) {
        try (FileWriter writer = new FileWriter(fileName, true)) { 
            writer.write(note + "\n");
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while writing the note.");
            e.printStackTrace();
        }
    }

    
    public static void readNotesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found yet. Please write one first.");
        } catch (IOException e) {
            System.out.println("Error occurred while reading notes.");
            e.printStackTrace();
        }
    }
}

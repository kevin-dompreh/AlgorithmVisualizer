import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Algorithm Visualizer!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Sorting Algorithms");
            System.out.println("2. Searching Algorithms");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        SortingHandler.handle();
                        break;
                    case 2:
                        SearchingHandler.handle();
                        break;
                    case 3:
                        System.out.println("Exiting Algorithm Visualizer. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
            }
        }
    }
}

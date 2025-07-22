import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchingHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void handle() {
        while (true) {
            System.out.println("\n--- Searching Algorithms ---");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Jump Search");
            System.out.println("4. Interpolation Search");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 5) return;

                System.out.print("Enter array: ");
                int[] arr = Utils.parseArrayInput(scanner.nextLine());

                if (arr == null || arr.length == 0) {
                    System.out.println("Invalid array input.");
                    continue;
                }

                System.out.print("Enter target: ");
                int target = scanner.nextInt();
                scanner.nextLine();

                if ((choice == 2 || choice == 3 || choice == 4) && !Utils.isSorted(arr)) {
                    System.out.println("Array must be sorted for this algorithm.");
                    continue;
                }

                int result = -1;
                String complexity = "";

                switch (choice) {
                    case 1:
                        result = SearchAlgorithms.linearSearch(arr, target);
                        complexity = "O(n)";
                        break;
                    case 2:
                        result = SearchAlgorithms.binarySearch(arr, target);
                        complexity = "O(log n)";
                        break;
                    case 3:
                        result = SearchAlgorithms.jumpSearch(arr, target);
                        complexity = "O(√n)";
                        break;
                    case 4:
                        result = SearchAlgorithms.interpolationSearch(arr, target);
                        complexity = "O(log log n) avg, O(n) worst";
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }

                System.out.println("Array: " + Arrays.toString(arr));
                System.out.println("Target: " + target);
                System.out.println(result != -1 ? "Found at index: " + result : "Target not found.");
                System.out.println("Time Complexity: " + complexity);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }
}

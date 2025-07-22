import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortingHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void handle() {
        while (true) {
            System.out.println("\n--- Sorting Algorithms ---");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Heap Sort");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int algoChoice = scanner.nextInt();
                scanner.nextLine();

                if (algoChoice == 7) return;

                System.out.print("Enter array (e.g., 4,2,7): ");
                int[] array = Utils.parseArrayInput(scanner.nextLine());

                if (array == null || array.length == 0) {
                    System.out.println("Invalid array input.");
                    continue;
                }

                int[] original = Arrays.copyOf(array, array.length);
                String complexity = "";

                switch (algoChoice) {
                    case 1:
                        SortAlgorithms.bubbleSort(array);
                        complexity = "O(n^2)";
                        break;
                    case 2:
                        SortAlgorithms.selectionSort(array);
                        complexity = "O(n^2)";
                        break;
                    case 3:
                        SortAlgorithms.insertionSort(array);
                        complexity = "O(n^2)";
                        break;
                    case 4:
                        array = SortAlgorithms.mergeSort(array);
                        complexity = "O(n log n)";
                        break;
                    case 5:
                        SortAlgorithms.quickSort(array, 0, array.length - 1);
                        complexity = "O(n log n) avg, O(n^2) worst";
                        break;
                    case 6:
                        SortAlgorithms.heapSort(array);
                        complexity = "O(n log n)";
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }

                System.out.println("Original Array: " + Arrays.toString(original));
                System.out.println("Sorted Array:   " + Arrays.toString(array));
                System.out.println("Time Complexity: " + complexity);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }
}

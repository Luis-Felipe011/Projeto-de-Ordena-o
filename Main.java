import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha o algoritmo de ordenação:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Heap Sort");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            System.out.print("Quantos números você deseja ordenar? ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            System.out.println("Digite os números:");
            for (int i = 0; i < n; i++) {
                System.out.print("Número " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }

            SortAlgoritimo algoritimo = null;
            switch (choice) {
                case 1:
                    algoritimo = new BubbleSort();
                    break;
                case 2:
                    algoritimo = new SelectionSort();
                    break;
                case 3:
                    algoritimo = new InsertionSort();
                    break;
                case 4:
                    algoritimo = new MergeSort();
                    break;
                case 5:
                    algoritimo = new QuickSort();
                    break;
                case 6:
                    algoritimo = new HeapSort();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            long start = System.nanoTime();
            algoritimo.sort(array);
            long end = System.nanoTime();

            System.out.println("Array ordenado:");
            for (int num : array) {
                System.out.print(num + " ");
            }

            System.out.printf("\nTempo de execução: %.2f ms%n", (end - start) / 1_000_000.0);
        }

        scanner.close();
    }
}

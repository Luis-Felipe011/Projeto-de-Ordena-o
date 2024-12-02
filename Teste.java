import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        // Tamanhos dos arrays para teste
        int[] sizes = {100, 1000, 10000, 50000, 100000};
        Random random = new Random();

        // Testar cada tamanho de array
        for (int size : sizes) {
            System.out.println("\nTamanho do array: " + size);

            // Gerar um array aleatório para cada tamanho
            int[] array = generateRandomArray(size, random);

            // Testar cada algoritmo
            testAlgorithm(new BubbleSort(), array.clone(), "Bubble Sort");
            testAlgorithm(new SelectionSort(), array.clone(), "Selection Sort");
            testAlgorithm(new InsertionSort(), array.clone(), "Insertion Sort");
            testAlgorithm(new MergeSort(), array.clone(), "Merge Sort");
            testAlgorithm(new QuickSort(), array.clone(), "Quick Sort");
            testAlgorithm(new HeapSort(), array.clone(), "Heap Sort");
        }
    }

    // Método para gerar um array aleatório
    private static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000); // Números aleatórios entre 0 e 100.000
        }
        return array;
    }

    // Método para testar um algoritmo de ordenação
    private static void testAlgorithm(SortAlgoritimo algorithm, int[] array, String algorithmName) {
        System.out.print("Testando " + algorithmName + "... ");
        long start = System.nanoTime();
        algorithm.sort(array);
        long end = System.nanoTime();

        double durationMs = (end - start) / 1_000_000.0;
        System.out.printf("Tempo: %.2f ms%n", durationMs);
    }
}

package _2_JavaCore._2_15_AlgorithmsPartTwo.main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = generateRandomArray(100_000);
        int[] arr2 = generateRandomArray(100_000);
        int[] arr3 = generateRandomArray(100_000);

        int[] arrA = Arrays.copyOf(arr1, arr1.length);
        int[] arrB = Arrays.copyOf(arr2, arr2.length);
        int[] arrC = Arrays.copyOf(arr3, arr3.length);

        long start = System.currentTimeMillis();
        sortBubble(arrA);
        System.out.print("sortBubble: " + (System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortBubble(arrB);
        System.out.print((System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortBubble(arrC);
        System.out.println((System.currentTimeMillis() - start));


        arrA = Arrays.copyOf(arr1, arr1.length);
        arrB = Arrays.copyOf(arr2, arr2.length);
        arrC = Arrays.copyOf(arr3, arr3.length);

        start = System.currentTimeMillis();
        sortSelection(arrA);
        System.out.print("sortSelection: " + (System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortSelection(arrB);
        System.out.print((System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortSelection(arrC);
        System.out.println((System.currentTimeMillis() - start));


        arrA = Arrays.copyOf(arr1, arr1.length);
        arrB = Arrays.copyOf(arr2, arr2.length);
        arrC = Arrays.copyOf(arr3, arr3.length);

        start = System.currentTimeMillis();
        sortInsertion(arrA);
        System.out.print("sortInsertion: " + (System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortInsertion(arrB);
        System.out.print((System.currentTimeMillis() - start) + ", ");
        start = System.currentTimeMillis();
        sortInsertion(arrC);
        System.out.println((System.currentTimeMillis() - start));
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int[] generateRandomArray(int length) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000_00) + 100_000_00;
        }
        return arr;
    }
}

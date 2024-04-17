package Optimizacion_de_procesos;

import java.util.Arrays;
import java.util.Random;

public class Optimizacion_de_algoritmos {

    private static Random rand = new Random();

    public void quickSort(int[] arr, int low, int high, boolean ascendente) {
        if (low < high) {
            if (low == 0 && high == arr.length - 1) {
                printArrayWithDelay(arr);
            }
            int pivotIndex = partition(arr, low, high, ascendente);
            quickSort(arr, low, pivotIndex - 1, ascendente);
            quickSort(arr, pivotIndex + 1, high, ascendente);
        }
    }

    private int partition(int[] arr, int low, int high, boolean ascendente) {
        int pivotIndex = medianOfThree(arr, low, high);
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int storeIndex = low;
        for (int i = low; i < high; i++) {
            if (ascendente ? arr[i] < pivotValue : arr[i] > pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
                printArrayWithDelay(arr);
            }
        }
        swap(arr, storeIndex, high);
        printArrayWithDelay(arr);
        return storeIndex;
    }

    private void printArrayWithDelay(int[] arr) {
        System.out.println(Arrays.toString(arr));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupted status
            System.out.println("Thread was interrupted, Failed to complete operation");
        }
    }

    private int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        return mid;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
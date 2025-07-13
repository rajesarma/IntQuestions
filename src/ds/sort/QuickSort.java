package ds.sort;

public class QuickSort {
    // Time Complexity
    // Worst case : O(n^2)
    // Average case : O(nlogn)
    void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex-1);
            sort(arr, pivotIndex+1, high);
        }
    }
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
             if (arr[j] < pivot) {
                 i++;
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i; // pivot index
    }
}

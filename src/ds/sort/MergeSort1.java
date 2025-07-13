package ds.sort;

public class MergeSort1 {

    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] leftSubArr = new int[n1];
        int[] rightSubArr = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            leftSubArr[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightSubArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;

        int k = low;
        while (i < n1 && j < n2) {
            if (leftSubArr[i] <= rightSubArr[j]) {
                arr[k] = leftSubArr[i];
                i++;
            } else {
                arr[k] = rightSubArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = leftSubArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = rightSubArr[j];
            j++;
            k++;
        }
    }


}

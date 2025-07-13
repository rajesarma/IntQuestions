package ds.sort;

public class MergeSort2 {
    int[] arr;
    int[] tmp;

    public MergeSort2(int[] arr) {
        this.arr = arr;
        tmp = new int[arr.length];
    }
    void sort() {
        mergeSort(0, arr.length-1);
    }
    void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int i = left;
        int j = left;
        int k = mid +1;
        while(j <= mid && k <= right) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        for (i = left; i < k; i ++) {
            arr[i] = tmp[i];
        }
    }
}

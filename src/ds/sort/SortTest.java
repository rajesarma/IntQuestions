package ds.sort;

public class SortTest {

	public static void main(String[] args) {
		int[] elements = {10, 6, 7, 4, 5, 2, 1, 8, 3};
		// Bubble Sort Test
//		BubbleSort bubbleSort = new BubbleSort();
//		bubbleSort.sort(elements);

//		SelectionSort selectionSort = new SelectionSort();
//		selectionSort.sort(elements);

//		InsertionSort sort = new InsertionSort();
//		sort.sort(elements);

//		QuickSort sort = new QuickSort();
//		sort.sort(elements, 0, elements.length - 1);

//		MergeSort mergeSort = new MergeSort(elements);
//		mergeSort.sort(elements, 0, elements.length-1);
//		mergeSort.sort();

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(elements, 0, elements.length-1);

		for (int i=0; i < elements.length; ++i) {
            System.out.print(elements[i] + " ");
        }
	}
}






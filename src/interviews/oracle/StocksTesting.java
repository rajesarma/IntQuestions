package interviews.oracle;

public class StocksTesting {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {7,6,4,3,1};
        int maxStock = maxStock(arr);
        System.out.println("maxStock maxStock :: " + maxStock);
    }

    public static int maxStock(int[] arr) {
        int maxStock = 0;
        int biggest;
        int index = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            biggest = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > biggest && maxStock >= 0) {
                    biggest = arr[j];
                    index = j;
                    maxStock = arr[j] - arr[i];
                    max = Math.max(maxStock, max);
                }
            }
        }
        if (index > 0) {
            return max;
        } else {
            max = 0;
        }
        return max;
    }
}



//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//        Constraints:

//Input: prices = [7, 1, 5, 3, 6, 4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

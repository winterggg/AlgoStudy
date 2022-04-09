package SortAlgo.BubbleSort;

import SortAlgo.base.SortAlgoBase;

public class BubbleSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "冒泡排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        final int N = arr.length;
        for (int i = 0; i < N; ++i) {
            boolean isSwapped = false;
            // arr[n-i, n) 已经排序，在 n-i-1 上摆放合适的元素
            for (int j = 1; j < N - i; ++j) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    isSwapped = true;
                    swap(arr, j - 1, j);
                }
            }
            if (!isSwapped) return;
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.checkOrdered();
    }
}

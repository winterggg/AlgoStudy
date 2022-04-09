package SortAlgo.BubbleSort;

import SortAlgo.base.SortAlgoBase;

public class BubbleSort2 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "冒泡排序 优化";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        final int N = arr.length;
        for (int i = 0; i < N; ++i) {
            int last = 0;
            // arr[n-i, n) 已经排序，在 n-i-1 上摆放合适的元素
            for (int j = 1; j < N - i; ++j) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    last = j; // [j, n) 为最终位置
                    swap(arr, j - 1, j);
                }
            }
            // [j, n) 为最终位置 arr[n-i, n) 已经排序， i+1 = n-j, 不过还要考虑最后的 i++
            i = N - last - 1;
        }
    }

    public static void main(String[] args) {
        BubbleSort2 bubbleSort = new BubbleSort2();
        bubbleSort.checkOrdered();
    }
}

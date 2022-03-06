package SortAlgo.QuickSort;

import SortAlgo.base.SortAlgoBase;

import java.util.Arrays;

public class QickSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "快速排序 版本一";
    }

    @Override
    protected <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        final E v = arr[l];
//        [l+1, j] < v, [j+1, i) >= v
        int j = l;
        for (int i = l + 1; i <= r; ++i) {
            if (arr[i].compareTo(v) < 0) { // i 指向的 < v
                j++; // j 跨越分界点，
                swap(arr, i, j); // 与 i 交换
            }
        }
        swap(arr, l, j);
        return j;
    }
    public static void main(String[] args) {
        new QickSort();
    }
}

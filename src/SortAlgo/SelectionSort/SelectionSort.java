package SortAlgo.SelectionSort;

import SortAlgo.base.SortAlgoBase;

public class SelectionSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "选择排序";
    }

    @Override
    protected <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j].compareTo(arr[minIdx]) < 0)
                    minIdx = j;
            }

            swap(arr, i, minIdx);
        }
    }

    public static void main(String[] args) {
        new SelectionSort().check();
        new SelectionSort().checkOrdered();
    }
}

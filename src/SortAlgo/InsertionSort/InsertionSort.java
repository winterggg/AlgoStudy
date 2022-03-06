package SortAlgo.InsertionSort;

import SortAlgo.base.SortAlgoBase;

public class InsertionSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "选择排序 ver1";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // 把 arr[i] 插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new InsertionSort();
    }
}

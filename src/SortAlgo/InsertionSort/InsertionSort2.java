package SortAlgo.InsertionSort;

import SortAlgo.base.SortAlgoBase;

public class InsertionSort2 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "选择排序 ver2";
    }

    @Override
    protected <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // 把 arr[i] 插入到合适的位置
            E p = arr[i];
            int j = i;
            for (; j - 1 >= 0; j--) {
                if (p.compareTo(arr[j-1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = p;
        }
    }

    public static void main(String[] args) {
        new InsertionSort2();
    }
}

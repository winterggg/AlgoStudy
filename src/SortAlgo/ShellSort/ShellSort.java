package SortAlgo.ShellSort;

import SortAlgo.base.SortAlgoBase;

public class ShellSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "希尔排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            // start: 每一个数组起始时的位置索引
            for (int start = 0; start < h; start++) {
                // 对 data[start, start+h, start+2h, ...] 进行插入排序
                for (int i = start + h; i < arr.length; i += h) {
                    E t = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && arr[j - h].compareTo(t) > 0; j -= h) {
                        arr[j] = arr[j - h];
                    }
                    arr[j] = t;
                }
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.checkOrdered();
    }
}

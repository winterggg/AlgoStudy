package SortAlgo.ShellSort;

import SortAlgo.base.SortAlgoBase;

public class ShellSort3 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "希尔排序 3";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        int h = 1;
        while (h < arr.length) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < arr.length; i += h) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && arr[j - h].compareTo(t) > 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = t;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        ShellSort3 shellSort = new ShellSort3();
        shellSort.checkOrdered();
    }
}

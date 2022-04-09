package SortAlgo.ShellSort;

import SortAlgo.base.SortAlgoBase;

public class ShellSort2 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "希尔排序 2";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            for (int i = h; i < arr.length; i += h) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && arr[j - h].compareTo(t) > 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = t;
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        ShellSort2 shellSort = new ShellSort2();
        shellSort.checkOrdered();
    }
}

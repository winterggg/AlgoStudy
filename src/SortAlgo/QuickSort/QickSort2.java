package SortAlgo.QuickSort;

import SortAlgo.base.SortAlgoBase;

import java.util.Random;

public class QickSort2 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "快速排序 添加随机化+双路快速排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static Random rnd = new Random();

    private <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int rand = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, rand);
        final E v = arr[l];
        int i = l + 1, j = r;
        for (; ; ) {
            while (i <= j && arr[i].compareTo(v) < 0) i++;
            while (i <= j && arr[j].compareTo(v) > 0) j--;
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        new QickSort2();
    }
}

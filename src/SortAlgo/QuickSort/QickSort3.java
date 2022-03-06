package SortAlgo.QuickSort;

import SortAlgo.base.SortAlgoBase;

import java.util.Random;

public class QickSort3 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "快速排序 添加随机化+三路快速排序";
    }

    @Override
    protected <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static Random rnd = new Random();

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        // arr[l+1, lt] < v, arr[lt+1, i-1] = v, arr[gt, r] > v
        final E v = arr[l];
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            E cur = arr[i];
            if (cur.compareTo(v) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (cur.compareTo(v) > 0) {
                gt--;
                swap(arr, i, gt);
                // i 此时指向未处理元素，不用++
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        // 此时： arr[l+1, lt-1] < v, arr[lt, gt-1] = v, arr[gt, r] > v
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void main(String[] args) {
        new QickSort3();
    }
}

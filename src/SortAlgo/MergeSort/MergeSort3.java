package SortAlgo.MergeSort;

import SortAlgo.base.SortAlgoBase;

import java.util.Arrays;

public class MergeSort3 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "归并排序 迭代版本";
    }

    @Override
    protected <E extends Comparable<E>> void sort(E[] arr) {
        E[] aux = Arrays.copyOf(arr, arr.length);
        final int n = arr.length;

        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), aux);
                }
            }
        }
    }


    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] aux) {
        for (int i = l; i <= r; ++i) {
            aux[i] = arr[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i < mid + 1 && j < r + 1) {
            if (aux[i].compareTo(aux[j]) < 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
        while (i < mid + 1) {
            arr[k++] = aux[i++];
        }
        while (j < r + 1) {
            arr[k++] = aux[j++];
        }
    }

    public static void main(String[] args) {
        new MergeSort3();
    }
}

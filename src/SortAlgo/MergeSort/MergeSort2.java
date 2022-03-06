package SortAlgo.MergeSort;

import SortAlgo.InsertionSort.InsertionSort;
import SortAlgo.base.SortAlgoBase;

import java.util.Arrays;

public class MergeSort2 extends SortAlgoBase {
    @Override
    protected String getName() {
        return "归并排序 递归版本2";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
//        if (r - l <= 15) {
//            // 使用插入排序
//            return;
//        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // mid + 1 不会越界
        if (arr[mid].compareTo(arr[mid + 1]) <= 0) return;
        E[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = 0;
        int j = mid - l + 1;
        int k = l;
        while (i < mid - l + 1 && j < r + 1 - l) {
            if (aux[i].compareTo(aux[j]) < 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
        while (i < mid - l + 1) {
            arr[k++] = aux[i++];
        }
        while (j < r + 1 - l) {
            arr[k++] = aux[j++];
        }
    }

    public static void main(String[] args) {
        new MergeSort2();
    }
}

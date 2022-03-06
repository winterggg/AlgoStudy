package SortAlgo.HeapSort;

import SortAlgo.base.SortAlgoBase;

public class HeapSort extends SortAlgoBase {
    @Override
    protected String getName() {
        return "堆排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        final int n = arr.length;

        // 就地建立二叉堆：升序排序->最大堆，降序排序->最小堆
        // k 初始为最后一个叶子节点的父节点
        for (int k = (n - 1 - 1) / 2; k >= 0; k--) {
            sink(arr, k, n);
        }


        // 排序
        int k = n - 1;
        while (k > 0) {
            swap(arr, 0, k--);
            sink(arr, 0, k);
        }
    }

    private void sink(Comparable[] pq, int k, int n) {
        while (2 * k + 1 < n) { // 左节点未越界
            int j = 2 * k + 1;
            if (j + 1 < n && pq[j].compareTo(pq[j + 1]) < 0) j++;
            if (pq[j].compareTo(pq[k]) <= 0) break;
            swap(pq, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        new HeapSort();
    }
}

package DS;

public class MaxPQ<E extends Comparable<E>> {
    private E[] pq;
    private int N;

    public MaxPQ(int cap) {
        pq = (E[]) new Comparable[cap];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(E e) {
        pq[N++] = e;
        swim(N - 1);
    }

    public E delMax() {
        E res = pq[0];
        swap(0, N - 1);
        pq[N - 1] = null;
        N--;
        sink(0);
        return res;
    }

    private void swim(int k) {
        while (k > 0 && pq[k].compareTo(pq[(k - 1) / 2]) > 0) {
            int p = (k - 1) / 2;
            swap(k, p);
            k = p;
        }
    }

    private void sink(int k) {
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j + 1 < N && pq[j + 1].compareTo(pq[j]) > 0) {
                j++;
            }
            if (pq[k].compareTo(pq[j]) >= 0) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        E t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        final int K = 3;
        MaxPQ<Integer> pq = new MaxPQ<>(K + 1);
        int[] arr = {1, 3, 4, 2, -99, 5, 11, -12, -5, 12, 9};
        for (int i : arr) {
            pq.insert(i);
            if (pq.size() > K) {
                pq.delMax();
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }

    }
}

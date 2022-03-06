package SortAlgo.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

abstract public class SortAlgoBase {

    public SortAlgoBase() {
        check();
    }

    abstract protected String getName();

    private static Integer[] orderedArray(int n) {
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i;
        }
        return res;
    }

    private static Integer[] randomArray(int n) {
        return randomArray(n, n, null);
    }

    private static Integer[] randomArray(int n, int bound) {
        return randomArray(n, bound, null);
    }


    private static Integer[] randomArray(int n, int bound, Integer seed) {
        Integer[] arr = new Integer[n];
        Random rnd;
        if (seed == null) {
            rnd = new Random();
        } else {
            rnd = new Random(seed);
        }
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    private static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    abstract protected <E extends Comparable<E>> void sort(E[] arr);

    protected void check() {
        Integer[] test = randomArray(1000, 300);
        sort(test);
        if (isSorted(test) && new HashSet<Integer>(Arrays.asList(test)).equals(new HashSet<Integer>(Arrays.asList(test)))) {
            System.out.print(getName() + " 测试通过，用时：");
            // 测试用时
            Integer[] arr = randomArray(20000, 10000);
            long startTime = System.nanoTime();
            sort(arr);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println(time + "s");
        } else {
            System.out.println(getName() + " 测试失败");
        }
    }

    protected void checkOrdered() {
        Integer[] test = orderedArray(1000);
        sort(test);
        if (isSorted(test) && new HashSet<Integer>(Arrays.asList(test)).equals(new HashSet<Integer>(Arrays.asList(test)))) {
            System.out.print(getName() + " 有序数据测试通过，用时：");
            // 测试用时
            Integer[] arr = orderedArray(60000);
            long startTime = System.nanoTime();
            sort(arr);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println(time + "s");
        } else {
            System.out.println(getName() + " 测试失败");
        }
    }

        protected <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(orderedArray(5)));
//        System.out.println(Arrays.toString(randomArray(5)));
//        System.out.println(Arrays.toString(randomArray(10, 5)));
//        System.out.println(Arrays.toString(randomArray(10, 5, 1)));
//        System.out.println(Arrays.toString(randomArray(10, 5, 1)));
//
//        System.out.println(isSorted(randomArray(10)));
//        System.out.println(isSorted(orderedArray(1000)));
    }
}

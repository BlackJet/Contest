package algo.sort;

import java.util.Arrays;

public class BubbleSorter implements Sorter {

    private int[] a;

    @Override
    public int[] sort(int[] a) {
        this.a = a;

        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if(a[j] < a[j-1]) swap(j, j -1);
            }
        }
        return a;
    }

    private void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {4,2,1,7,6,9,8};

        Sorter sorter = new BubbleSorter();

        System.out.println(Arrays.toString(sorter.sort(a)));
    }
}

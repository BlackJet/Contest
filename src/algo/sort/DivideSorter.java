package algo.sort;

import java.util.Arrays;

class DivideSorter {

    private int[] a;

    public void sort(int[] a) {
        this.a = a;
        sort(0, a.length - 1);
    }

    public void sort(int startIndex, int endIndex) {

        if(startIndex >= endIndex) return;

        int pivotIndex = divide(startIndex, endIndex);

        sort(startIndex, pivotIndex - 1);
        sort(pivotIndex + 1, endIndex);

    }

    private int divide(int startIndex, int endIndex) {

        int optimalIndex = getOptimalIndex(startIndex, endIndex);

        int pivot = a[optimalIndex];
        swap(optimalIndex, endIndex);

        int marker = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (a[i] <= pivot) {
                swap(i, marker);
                marker++;
            }
        }

        swap(marker, endIndex);
        return marker;
    }

    private int getOptimalIndex(int startIndex, int endIndex) {

        return startIndex + (endIndex - startIndex) /2;

    }

    private void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        DivideSorter sorter = new DivideSorter();
        int[] a = {4,3,6,5,7,1,5,5,5};
//        int[] a = {4,3,6};
//        int[] a = {4,4,3};
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }


}
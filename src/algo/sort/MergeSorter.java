package algo.sort;


import java.util.Arrays;

public class MergeSorter implements Sorter {

    @Override
    public int[] sort(int[] a) {
        return mergeSort(a);
    }

    private int[] mergeSort(int[] a ) {
        if(a.length == 1) return a;

        int middle = a.length / 2;
        int[] left = new int[middle];
        int[] right = new int[a.length - middle];
        System.arraycopy(a, 0, left, 0, middle);
        System.arraycopy(a, middle, right, 0, a.length - middle);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if(left[i] < right[j]) result[k] = left[i++];
            else result[k] = right[j++];
            k++;
        }

        if(i == left.length) {
            for (; j < right.length; j++) {
                result[k++] = right[j];
            }
        }

        if(j == right.length) {
            for (; i < left.length; i++) {
                result[k++] = left[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,2,1,7,6,9,8};
        Sorter sorter = new MergeSorter();

        System.out.println(Arrays.toString(sorter.sort(a)));
    }


}

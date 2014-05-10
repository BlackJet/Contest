package algo;

import java.util.Arrays;

public class Sorters {

    public static void main(String[] args) {

        int[] a = {3,5,6,2,9,7,1,8,4};
//        int[] a = {3,1,5};
        Orderer orderer = new QuickSorter();
        orderer.order(a);
        System.out.println(Arrays.toString(a));
    }
}

interface Orderer {
    int[] order(int[] a);
}

class QuickSorter implements Orderer {

    private int[] array;

    public int[] order(int[] a) {
        array = a;
        order(0, a.length - 1);
        return array;
    }

    private void order(int startIndex, int endIndex) {
        if(startIndex >= endIndex) return;
        int pivotIndex = getPivotIndex(startIndex, endIndex);
        int orderPosition = setupOrderPosition(pivotIndex, startIndex, endIndex);
        order(startIndex, orderPosition - 1);
        order(orderPosition + 1, endIndex);
    }

    private int getPivotIndex(int startIndex, int endIndex) {
        return startIndex + (endIndex - startIndex) / 2;
    }

    private int setupOrderPosition(int valuePosition, int startIndex, int endIndex) {
        swap(valuePosition, endIndex);
        int firstBiggerValuePosition = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            if(array[i] <= array[endIndex]) {
                swap(i, firstBiggerValuePosition++);
            }
        }

        return firstBiggerValuePosition - 1;
    }

    private void swap(int position1, int position2) {
        int tmp = array[position1];
        array[position1] = array[position2];
        array[position2] = tmp;
    }
}

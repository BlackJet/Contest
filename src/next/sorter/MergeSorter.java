package next.sorter;

import next.Sorter;

// TODO implement with one additional array
public class MergeSorter implements Sorter {

    @Override
    public int[] sort(int[] a) {
        return mergeSort(a);
    }

    private int[] mergeSort(int[] a) {
        if(a.length == 1) return a;
        int leftLen = a.length / 2;

        int rightLen = a.length - leftLen;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        System.arraycopy(a, 0, left, 0, leftLen);
        System.arraycopy(a, leftLen, right, 0, rightLen);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int leftLen = left.length, rightLen = right.length;
        int leftPos = 0, rightPos = 0;
        int[] result = new int[leftLen + rightLen];
        int resultPos = 0;
        while(leftPos < leftLen && rightPos < rightLen) {
            if(left[leftPos] < right[rightPos]) {
                result[resultPos++] = left[leftPos++];
            }
            else {
                result[resultPos++] = right[rightPos++];
            }
        }

        if(leftPos < leftLen) {
            int count = leftLen - leftPos;
            System.arraycopy(left, leftPos, result, resultPos, count );
        }

        if(rightPos < rightLen) {
            int count = rightLen - rightPos;
            System.arraycopy(right, rightPos, result, resultPos, count );
        }

        return result;

    }


}

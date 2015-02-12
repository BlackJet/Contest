package next.sorter;

import next.Sorter;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public int[] sort(int[] a) {
        this.a = a;
        sort(0, a.length - 1);
        return a;
    }

    public void sort(int startIndex, int endIndex) {
        if(startIndex >= endIndex) return;
        int pivotPos = divideGetPivotPos(startIndex, endIndex);
        sort(startIndex, pivotPos - 1);
        sort(pivotPos + 1, endIndex);
    }

    private int divideGetPivotPos(int startIndex, int endIndex) {
        int pivotPos = getOptimalPos(startIndex, endIndex);
        int pivotValue = a[pivotPos];
        swap(a, endIndex, pivotPos);
        int firstGreaterPos = -1;
        for(int i = startIndex; i < endIndex; i++) {
            if(a[i] < pivotValue ) {
                if(firstGreaterPos == -1) continue;
                swap(a, i, firstGreaterPos);
                firstGreaterPos++;
            }
            else if(firstGreaterPos == -1) {
                firstGreaterPos = i;
            }
        }

        if(firstGreaterPos > -1) swap(a, firstGreaterPos, endIndex);
        return firstGreaterPos;
    }

    private int getOptimalPos(int i, int j) {
        return i + (j - i ) / 2;
    }

}

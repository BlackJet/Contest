package next.sorter;

import next.Sorter;

public class BubbleSorter implements Sorter {

    @Override
    public int[] sort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = a.length - 1; j > i; j--) {
                if(a[j] < a[j-1]) swap(a, j, j-1);
            }
        }
        return a;
    }

}

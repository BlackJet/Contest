package next.sorter;

import next.Sorter;

public class InsertSorter implements Sorter {

    @Override
    public int[] sort(int[] a) {

        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0; j--) {
                if(a[j] < a[j-1]) swap(a, j, j-1);
            }

        }
        return a;
    }

}

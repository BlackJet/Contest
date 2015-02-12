package next.sorter;

import next.Sorter;

public class SelectSorter implements Sorter {

    @Override
    public int[] sort(int[] a) {

        for(int i = a.length - 1; i > 0; i--) {
            int max = a[0];
            int maxj = 0;
            for(int j = 0; j <= i; j++) {
                if(a[j] > max) {
                    max = a[j];
                    maxj = j;
                }
            }

            swap(a, i, maxj);

        }
        return a;
    }

}

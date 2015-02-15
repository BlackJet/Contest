package next.sorter;

import next.Sorter;

import java.util.Arrays;

public class HeapSorter implements Sorter {

    private int[] a;
    private int len = 0;

    @Override
    public int[] sort(int[] a) {
        this.a = a;
        len = a.length;

        for(int i = 0; i < len; i++) {
            bubbleUp(i);
        }

        for(int i = 0; i < a.length; i++) {
            popToEnd();
        }

        return a;
    }

    public void popToEnd() {
        swap(a, 0, len - 1);
        len--;
        bubbleDown(0);
    }

    private void bubbleUp(int pos) {
        int last = a[pos];
        Integer parentPos = parent(pos);
        if(parentPos != null) {
            if(a[parentPos] < last) {
                swap(a,pos, parentPos);
                bubbleUp(parentPos);
            }
        }
    }

    private Integer parent(int pos) {
        if(pos == 0) return null;
        return pos /2;
    }

    private void bubbleDown(int pos) {
        int c1Pos = 2*pos + 1;
        int c2Pos = 2*pos + 2;

        int maxPos = c1Pos;
        if(c1Pos <= len - 1) {
            if(c2Pos <= len - 1) {
                if(a[c1Pos] < a[c2Pos]) maxPos = c2Pos;
            }

            if(a[maxPos] > a[pos]) {
                swap(a, maxPos, pos);
                bubbleDown(maxPos);
            }
        }
    }

    public static void main(String[] args) {
        HeapSorter sorter = new HeapSorter();

        int[] a = {4,7,1,8,5,9,10,22};
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }



}

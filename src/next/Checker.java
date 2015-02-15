package next;

import next.sorter.*;

import java.util.Arrays;

public class Checker {

    public static void main(String[] args) {
        Checker checker = new Checker();

        checker.check(new BubbleSorter());
        checker.check(new InsertSorter());
        checker.check(new SelectSorter());
        checker.check(new QuickSorter());
        checker.check(new MergeSorter());
        checker.check(new HeapSorter());

    }

    public void check(Sorter sorter) {
        int[] a = {4,7,1,8,5}, a0 = {1,4,5,7,8};
        int[] b = {1,2,3,4}, b0 = {1,2,3,4};
        int[] c = {6,6,0,9,1,7}, c0 = {0,1,6,6,7,9};
        int[] d = {1}, d0 = {1};

        a = sorter.sort(a);
        b = sorter.sort(b);
        c = sorter.sort(c);
        d = sorter.sort(d);

        System.out.println(sorter.getClass().getSimpleName() + ":");

        if(
            Arrays.equals(a, a0) &&
            Arrays.equals(b, b0) &&
            Arrays.equals(c, c0) &&
            Arrays.equals(d, d0) ) {
            println("True");
        } else {
            println(Arrays.toString(a));
            println(Arrays.toString(b));
            println(Arrays.toString(c));
            println(Arrays.toString(d));
        }


    }

    public static void println(Object that) {
        System.out.println(that);
    }

}

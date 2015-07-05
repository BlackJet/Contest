package algo3;

import algo3.order.*;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Tester checker = new Tester();

        checker.check(new BubbleOrderer());
        checker.check(new SelectOrderer());
        checker.check(new InsertOrderer());
        checker.check(new QuickOrderer());
        checker.check(new MergeOrderer());
        checker.check(new HeapOrderer());

    }

    public void check(Orderer orderer) {
        int[] a = {4,7,1,8,5}, a0 = {1,4,5,7,8};
        int[] b = {1,2,3,4}, b0 = {1,2,3,4};
        int[] c = {6,6,0,9,1,7}, c0 = {0,1,6,6,7,9};
        int[] d = {1}, d0 = {1};

        a = orderer.order(a);
        b = orderer.order(b);
        c = orderer.order(c);
        d = orderer.order(d);

        System.out.println(orderer.getClass().getSimpleName() + ":");

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

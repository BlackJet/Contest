package contest.talentbuddy;

import java.util.*;

/**
 * User: Tony
 * Date: 06.05.14
 * Time: 21:31
 *
 */
public class TechInterview {

    public static void main(String[] args) {
//        balanced_brackets("())(()");
//        balanced_brackets2("())(()");
        balanced_brackets2(")()(");
    }

    public static void balanced_brackets2(String s) {
        int c = 0, o = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ')' ){
                c++;
            }
            if(s.charAt(i) == '('){
                o++;
            }
            if(c > o){
                break;
            }
        }
        if(c == o){
            System.out.print("Balanced");
        }else{
            System.out.print("Unbalanced");
        }
    }

    public static void find_missing_number(Integer[] v) {

        boolean[] exists = new boolean[v.length + 1];

        for (int i : v) exists[i - 1] = true;

        for (int i = 0; i < exists.length; i++) {
            if( !exists[i] ) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    public static void max_prod(Integer[] v) {

        int maxProd = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if( i == j) continue;
                int prod = v[i] * v[j];
                if(prod > maxProd && prod % 3 == 0) maxProd = prod;
            }
        }

        System.out.println(maxProd);

    }

    /**
     * Что будет если в иф идет null
     * @param s
     */

    public static void balanced_brackets(String s) {

        Stack<Boolean> stack = new Stack<>();
        boolean open = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(open);
            } else {
                if (stack.empty()) {
                    System.out.println("Unbalanced");
                    return;
                }
                stack.pop();
            }

        }

        System.out.println("Balanced");
    }

    public static void sort_names(String[] names) {

        Map<String, List<String>> map = new TreeMap<>();
        for (String name : names) {
            String lastName = name.split("\\s")[1];
            if(!map.containsKey(lastName)) {
                map.put(lastName, new ArrayList<String>());
            }
            map.get(lastName).add(name);
        }

        for (String lastName : map.keySet()) {
            for (String name : map.get(lastName)) {
                System.out.println(name);
            }
        }
    }

    public static void nth_number(Integer[] v, Integer n) {

        int min1 = 0, min2 = 0, min3 = 0;

        for (Integer value : v) {

        }
    }

    public static void count_occurences(Integer[] v, Integer k) {
        boolean started = false;
        int counter = 0;
        for (int value : v) {
            if(value == k) {
                counter++;
                started = true;
            } else if(started) {
                System.out.println(counter);
                return;
            }
        }

        System.out.println(counter);

    }

    public static void solve_equation(Double a, Double b) {
        Double d = -b/a;
        if(d.isInfinite() || d.isNaN()) System.out.println("INF");
        else System.out.println(d);
    }

}

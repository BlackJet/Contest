package talentbuddy;

/**
 * User: Tony
 * Date: 06.05.14
 * Time: 21:31
 */
public class TechInterview {

    public static void main(String[] args) {
        find_missing_number(new Integer[] {5,2,4,1});
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


    }

}

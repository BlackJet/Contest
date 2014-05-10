package contest.coderbyte;

public class Easy {
    public static void compute_active_users(Integer n, Integer b) {
        double nd = n;
        double bd = b;
        int r = (int)Math.floor(nd - nd * bd/100);
        System.out.println(r);
    }

    boolean isArithmetic(int[] arr) {

        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    boolean isGeometric(int[] arr) {
        int d = arr[1]/arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]/arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    int getSequenceType(int[] arr) {

        if(arr.length < 3) return -1;
        if (isArithmetic(arr)) {
            return 0;
        }
        if (isGeometric(arr)) {
            return 1;
        }

        return -1;
    }

    String transformValue(int val) {
        switch (val) {
            case 0: return "Arithmetic";
            case 1: return "Geometric";
            case -1:
            default:
                return "-1";
        }

    }

    String ArithGeo(int[] arr) {
        return transformValue(getSequenceType(arr));
    }

    String FirstReverse(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() -1 ; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }

}

package contest.talentbuddy.techinterview;

/**
 * User: Tony
 * Date: 10.05.14
 * Time: 16:45
 */
public class SortingAndOrderStatistics {

    public static void main(String[] args) {
        Integer[] b = {1,1,2,3,4,1,6,1,1,1,1};
        majority(b);
    }

    public static void nth_number(Integer[] v, Integer n) {
        int value = getNthValue(v, 0, v.length - 1, n);
        System.out.println(value);
    }

    private static int getNthValue(Integer[] a, int startIndex, int endIndex, int n) {
        int pivotValueIndex = startIndex + (endIndex - startIndex) / 2;
        int resultPivotValueIndex = setInOrderPosition(a, pivotValueIndex, startIndex, endIndex);

        if (resultPivotValueIndex + 1 == n) {
            return a[resultPivotValueIndex];
        }
        if (resultPivotValueIndex + 1 > n) {
            return getNthValue(a, startIndex, resultPivotValueIndex - 1, n);
        } else {
            return getNthValue(a, resultPivotValueIndex + 1, endIndex, n);
        }

    }

    private static int setInOrderPosition(Integer[] a, int pos, int startIndex, int endIndex) {
        swap(a, pos, endIndex);
        int firstSmallerValuePosition = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (a[i] >= a[endIndex]) {
                swap(a, i, firstSmallerValuePosition++);
            }
        }

        return firstSmallerValuePosition - 1;
    }

    private static void swap(Integer[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void copyTail(Object[] from, int fromStart, Object[] to, int toStart) {
        for (int i = fromStart; i < from.length; i++, toStart++) {
            to[toStart] = from[i];
        }
    }

    public static void merge_arrays(Integer[] a, Integer[] b) {
        Integer[] merge = new Integer[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (k < merge.length) {
            if (a[i] <= b[j]) {
                merge[k] = a[i++];
            } else {
                merge[k] = b[j++];
            }

            k++;

            if (i == a.length) {
                copyTail(b, j, merge, k);
                break;
            }

            if (j == b.length) {
                copyTail(a, i, merge, k);
                break;
            }
        }

        for (Integer value : merge) {
            System.out.print(value + " ");
        }
    }


    public static void relative_sort(Integer[] v) {
        int firstPositiveIndex = 0;
        for (int i = 0; i < v.length; i++) {
            if(v[i] < 0) {
                if(i != firstPositiveIndex){
                    int negative = v[i];
                    for (int j = i - 1; j >= firstPositiveIndex; j--) {
                        v[j + 1] = v[j];
                    }
                    v[firstPositiveIndex] = negative;
                }
                firstPositiveIndex++;
            }
        }

        for (Integer value : v) {
            System.out.print(value + " ");
        }
    }

    public static void majority(Integer[] v) {
        int median = getNthValue(v, 0, v.length - 1, v.length / 2);

        int majorityCount = 0;
        for (Integer value : v) {
            if(value == median) majorityCount++;
        }

        if(majorityCount > v.length / 2) {
            System.out.println(median);
        } else {
            System.out.println("None");
        }


    }



}


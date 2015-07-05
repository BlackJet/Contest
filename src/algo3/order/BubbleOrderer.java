package algo3.order;

public class BubbleOrderer extends ArrayOrderer {

    @Override
    public int[] orderArray() {
        for(int i = 0;  i < array.length; i++ ) {
            for(int j = array.length - 1; j > i; j--) {
                swapIfFirstIsLess(j, j - 1);
            }
        }
        return array;
    }
}

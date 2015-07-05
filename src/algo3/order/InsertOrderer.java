package algo3.order;

public class InsertOrderer extends ArrayOrderer {
    @Override
    protected int[] orderArray() {
        for (int i = 1; i < len(); i++) {
            bubbleDown(i);
        }
        return array;
    }

    private void bubbleDown(int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            if(swapIfFirstIsLess(pos, i)) pos = i;
            else return;
        }
    }
}

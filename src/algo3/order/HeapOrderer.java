package algo3.order;

public class HeapOrderer extends ArrayOrderer {

    private int heapLen = 0;

    @Override
    protected int[] orderArray() {
        heapLen = array.length;

        for(int i = 0; i < len(); i++) {
            bubbleUp(i);
        }

        for(int i = 0; i < len(); i++) {
            popToEnd();
        }

        return array;
    }

    private void popToEnd() {
        swap(0, heapLen - 1);
        heapLen--;
        bubbleDown(0);
    }

    private void bubbleUp(int pos) {
        Integer parentPos = parent(pos);
        if (parentPos != null && swapIfFirstIsLess(parentPos, pos)) {
            bubbleUp(parentPos);
        }

    }

    private void bubbleDown(int pos) {
        int firstChildPos = 2*pos + 1;
        int secondChildPos = 2*pos + 2;

        int greaterChildPos = firstChildPos;
        if(firstChildPos <= heapLen - 1) {
            if(secondChildPos <= heapLen - 1) {
                if(array[firstChildPos] < array[secondChildPos]) greaterChildPos = secondChildPos;
            }

            if(array[greaterChildPos] > array[pos]) {
                swap(greaterChildPos, pos);
                bubbleDown(greaterChildPos);
            }
        }
    }

    private Integer parent(int pos) {
        return pos == 0 ? null: pos / 2;
    }
}

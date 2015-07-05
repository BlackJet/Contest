package algo3.order;

public class QuickOrderer extends ArrayOrderer {
    @Override
    protected int[] orderArray() {
        order(0, array.length - 1);
        return array;
    }

    private void order(int start, int end) {
        if(start >= end) return;
        int separatorPos = divide(start, end);
        order(start, separatorPos - 1);
        order(separatorPos + 1, end);
    }

    private int getSeparatorPos(int start, int end) {
        return start + (end - start)/2;
    }

    private int divide(int start, int end) {

        int separatorPos = getSeparatorPos(start, end);
        swap(end, separatorPos);

        int firstGreatPos = -1;
        int separator = get(end);
        for (int i = start; i < end; i++) {
            if(get(i) <= separator) {
                if(firstGreatPos != -1) {
                    swap(firstGreatPos, i);
                    firstGreatPos++;
                }
            } else {
                if(firstGreatPos == -1) {
                    firstGreatPos = i;
                }
            }
        }

        if(firstGreatPos != -1) swap(firstGreatPos, end);
        return firstGreatPos == -1 ? end: firstGreatPos;
    }
}

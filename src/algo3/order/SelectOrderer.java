package algo3.order;

public class SelectOrderer extends ArrayOrderer {
    @Override
    protected int[] orderArray() {
        for(int i = 0; i < len(); i++) {
            swap(getPosOfMinimumFromPos(i), i);
        }
        return array;
    }

    private int getPosOfMinimumFromPos(int pos) {
        int min = get(pos), minPos = pos;
        for (int i = pos + 1; i < len(); i++) {
            if(get(i) < min) {
                minPos = i;
                min = get(i);
            }
        }
        return minPos;
    }

}

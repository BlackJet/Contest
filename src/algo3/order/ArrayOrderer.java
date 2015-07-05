package algo3.order;

public abstract class ArrayOrderer implements Orderer {

    protected int[] array;

    public ArrayOrderer() {
    }


    @Override
    public int[] order(int[] array) {
        setArray(array);
        return orderArray();
    }

    protected abstract int[] orderArray();

    protected void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    protected boolean swapIfFirstIsLess(int i, int j) {
        if(array[i] < array[j]) {
            swap(i, j);
            return true;
        }
        return false;
    }

    protected void setArray(int[] array) {
        this.array = array;
    }

    protected int len() {
        return array.length;
    }

    protected int get(int pos) {
        return array[pos];
    }


}

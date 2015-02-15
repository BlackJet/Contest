package next.structure;

import java.util.Arrays;

public class PriorityQueue {

    private int capacity = 10;
    private int[] heap;
    private int len = 0;

    public PriorityQueue() {
        heap = new int[capacity];
    }

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
    }

    public void push(int e) {
        if(len >= capacity) {
            throw new IllegalStateException("Error: capacity is bigger that len");
        }
        heap[len] = e;
        len++;

        bubbleUp(len - 1);
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private Integer parent(int pos) {
        if(pos == 0) return null;
        return pos /2;
    }

    public Integer pop() {
        if(len == 0) return null;
        int max = heap[0];
        heap[0] = heap[len - 1];
        len--;
        bubbleDown(0);
        return max;
    }

    private void bubbleUp(int pos) {
        int last = heap[pos];
        Integer parentPos = parent(pos);
        if(parentPos != null) {
            if(heap[parentPos] < last) {
                swap(pos, parentPos);
                bubbleUp(parentPos);
            }
        }
    }

    private void bubbleDown(int pos) {
        int c1Pos = 2*pos + 1;
        int c2Pos = 2*pos + 2;

        int maxPos = c1Pos;
        if(c1Pos <= len - 1) {
            if(c2Pos <= len - 1) {
                if(heap[c1Pos] < heap[c2Pos]) maxPos = c2Pos;
            }

            if(heap[maxPos] > heap[pos]) {
                swap(maxPos, pos);
                bubbleDown(maxPos);
            }
        }
    }

    public void clear() {
        len = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap) + ", length = " + len;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        queue.push(1);
        queue.push(2);
        queue.push(28);
        queue.push(0);
        queue.push(66);
        queue.push(20);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue);
    }

}

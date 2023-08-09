public class FixedSizeQueue {
    private int[] data;
    private int start;
    private int end;
    private int size;

    public FixedSizeQueue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity should not be less than 0");
        data = new int[capacity];
        start = end = size = 0;
    }

    public void push(int obj) {
        if (size == data.length) throw new ArrayIndexOutOfBoundsException("the queue is full");
        data[end] = obj;
        end = (end + 1) % data.length;
        size++;
    }

    public int poll() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("the queue is empty");
        int temp = data[start];
        start = (start + 1) % data.length;
        return temp;
    }

    public Integer peek() {
        if (size == 0) throw null;
        return data[start];
    }
}
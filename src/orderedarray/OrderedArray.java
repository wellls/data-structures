package orderedarray;

public class OrderedArray {
    private int capacity;
    private int lastPosition;
    private int[] values;

    public OrderedArray(int capacity) {
        this.capacity = capacity;
        this.lastPosition = -1;
        this.values = new int[capacity];
    }

    // O(n)
    public void print() {
        if (this.lastPosition == -1) {
            System.out.println("The vector is empty");
        } else {
            for (int i = 0; i <= this.lastPosition; i++) {
                System.out.println(i + " - " + this.values[i]);
            }
        }
    }

    // O(1)
    public void insert(int value) {
        if(this.lastPosition == capacity - 1) {
            System.out.println("Maximum capacity reached");
            return;
        }

        int position = 0;
        for (int i = 0; i <= this.lastPosition; i++) {
            position = i;
            if (this.values[i] > value) {
                break;
            }
            if (i == this.lastPosition) {
                position = i + 1;
            }
        }

        for (int x = this.lastPosition; x >= position; x--) {
            this.values[x + 1] = this.values[x];
        }

        this.values[position] = value;
        this.lastPosition++;
    }
    //O(n)
    public int linearSearch(int value) {
        for (int i = 0; i <= this.lastPosition; i++) {
            if (this.values[i] > value) {
                return -1;
            }
            if (this.values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int delete(int value) {
        int position = this.linearSearch(value);
        if (position == -1) {
            return -1;
        } else {
            for (int i = position; i < this.lastPosition; i++) {
                this.values[i] = this.values[i + 1];
            }
            this.lastPosition--;
            return position;
        }
    }

    public static void main(String[] args) {
        OrderedArray array = new OrderedArray(7);
        array.print();
        array.insert(5);
        array.insert(1);
        array.insert(10);
        array.insert(6);
        array.insert(8);
        array.print();

        int founded = array.linearSearch(5);
        int notFound = array.linearSearch(7);
        System.out.println("5 founded " + founded + " 7 notFound " + notFound);

        array.delete(5);
        array.delete(10);
        array.print();
        System.out.println("-----------");
        array.delete(1);
        array.print();

    }
}

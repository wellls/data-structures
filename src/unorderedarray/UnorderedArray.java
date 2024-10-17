package unorderedarray;

public class UnorderedArray {
    private int capacity;
    private int lastPosition;
    private int[] values;

    public UnorderedArray(int capacity) {
        this.capacity = capacity;
        this.lastPosition = -1;
        this.values = new int[capacity];
    }

    //o(n)
    public void print() {
        if (this.lastPosition == -1) {
            System.out.println("The array is empty");
        } else {
            for (int i = 0; i <= this.lastPosition; i++) {
                System.out.println(i + " - " + values[i]);
            }
        }
    }

    // O(1)
    public void insert(int value) {
        if (this.lastPosition == this.capacity - 1) {
            System.out.println("Maximum capacity reached");
        } else {
            this.lastPosition++;
            this.values[this.lastPosition] = value;
        }
    }

    // O(n)
    public int search(int value) {
        for (int i = 0; i <= this.lastPosition; i++) {
            if (value == this.values[i]) {
                return i;
            }
        }
        return -1;
    }

    // O(n)
    public int delete(int value) {
        int position = this.search(value);
        if (position == -1) {
            return -1;
        } else {
//            for (int i = position; i < this.lastPosition; i++) {
//              this.values[i] = this.values[i + 1]; O(n) relocates each item in the array to a previous position
//            }
            this.values[position] = this.values[this.lastPosition]; //O(1) replaces the item with the last position, better performance
            this.lastPosition--;
            return position;
        }
    }

    public static void main(String[] args) {
        UnorderedArray array = new UnorderedArray(7);
        array.print(); // The array is empty

        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.insert(50);
        array.insert(60);
        array.insert(70);
        array.print(); // 0 - 10, 1 - 20, 2 - 30, ...

        array.insert(50); // Maximum capacity reached

        System.out.println("40 position - " + array.search(40)); //3
        System.out.println("60 position - " + array.search(60)); //5

        array.delete(20);
        array.print(); // 0 - 10, 1 - 70, 2 - 30

        array.delete(10);
        array.print(); // 0 - 60, 1 - 70

        array.delete(30);
        array.print(); // 60, 70, 50, 40
    }
}



package org.example.queue_interface;

public class CircularBuffer {
    private int[] buffer;
    private int head, tail, size, capacity;

    // Constructor to initialize the buffer with a fixed size
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        if (size == capacity) {

            head = (head + 1) % capacity;
        } else {
            size++;
        }

        // Insert the new value at the tail position and move tail forward
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    // Get the current elements in the buffer
    public String getBuffer() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(buffer[(head + i) % capacity]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        // Insert elements into the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer after inserting 1, 2, 3: " + buffer.getBuffer());


        buffer.insert(4);
        System.out.println("Buffer after inserting 4: " + buffer.getBuffer());

        // Insert 5 which should overwrite the oldest element 2
        buffer.insert(5);
        System.out.println("Buffer after inserting 5: " + buffer.getBuffer());
    }
}

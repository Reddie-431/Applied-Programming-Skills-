class MyCircularDeque {
    private final int[] deque;
    private int front;
    private int count;
    private final int capacity;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.deque = new int[k];
        this.front = 0;
        this.count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // Move front index backward with wrap-around protection
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        // Calculate current rear index for insertion
        int rear = (front + count) % capacity;
        deque[rear] = value;
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int rear = (front + count - 1) % capacity;
        return deque[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
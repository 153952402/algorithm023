
public class MyCircularDeque {
    private int max = 0;
    private int size = 0;
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node prev;


        public Node(int value, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.max = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size >= max) {
            return false;
        }
        Node node = new Node(value, null, head);
        if(head == null) {
            head = tail = node;
        }else {
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size >= max) {
            return false;
        }

        Node node = new Node(value, tail, null);
        if(tail == null) {
            head = tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) {
            return false;
        }
        head = head.next;
        if(head == null) {
            tail = null;
        }else {
            head.prev = null;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) {
            return false;
        }
        tail = tail.prev;
        if(tail == null) {
            head = null;
        }else {
            tail.next = null;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) {
            return -1;
        }
        int value = head.value;
        return value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) {
            return -1;
        }
        int value = tail.value;
        return value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == max;
    }
}
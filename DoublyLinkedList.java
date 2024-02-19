public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, head, null);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null, tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    public T removeFirst() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // La lista está ahora vacía
        }
        return data;
    }

    public T removeLast() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // La lista está ahora vacía
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
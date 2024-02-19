public class SinglyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head = null;

    // Añade un elemento al inicio de la lista (útil para push en la pila)
    public void addFirst(T item) {
        head = new Node<>(item, head);
    }

    // Elimina y devuelve el primer elemento de la lista (útil para pop en la pila)
    public T removeFirst() {
        if (head == null) return null;
        T item = head.data;
        head = head.next;
        return item;
    }

    // Verifica si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }
}
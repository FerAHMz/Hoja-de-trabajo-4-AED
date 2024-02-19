public class DoubleNode<T> {
    private T data; // El dato almacenado en el nodo
    private DoubleNode<T> next; // Referencia al siguiente nodo en la lista
    private DoubleNode<T> prev; // Referencia al nodo anterior en la lista

    // Constructor para inicializar el nodo con datos, sin nodos adyacentes
    public DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Métodos de acceso y modificación para el dato
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Métodos de acceso y modificación para el nodo siguiente
    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    // Métodos de acceso y modificación para el nodo anterior
    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
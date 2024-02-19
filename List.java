public interface List<T> {
    void addFirst(T item); // Agrega un elemento al inicio de la lista
    void addLast(T item); // Agrega un elemento al final de la lista
    T removeFirst(); // Elimina y devuelve el primer elemento de la lista
    T removeLast(); // Elimina y devuelve el último elemento de la lista
    boolean isEmpty(); // Verifica si la lista está vacía
}
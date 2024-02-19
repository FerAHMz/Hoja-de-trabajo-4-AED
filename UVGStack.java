public interface UVGStack<T> {
    void push(T item); // Inserta un elemento en la cima de la pila
    T pop(); // Elimina y devuelve el elemento de la cima de la pila
    T peek(); // Devuelve el elemento de la cima de la pila sin eliminarlo
    boolean isEmpty(); // Verifica si la pila está vacía
}
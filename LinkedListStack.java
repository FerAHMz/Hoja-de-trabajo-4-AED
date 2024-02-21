import java.util.LinkedList;

public class LinkedListStack<T> implements UVGStack<T> {
    private LinkedList<T> stack;

    // Constructor para inicializar la pila
    public LinkedListStack() {
        this.stack = new LinkedList<>();
    }

    // Implementación de los métodos de la interfaz UVGStack
    @Override
    public void push(T item) {
        stack.addLast(item);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.removeLast();
        }
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.getLast();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
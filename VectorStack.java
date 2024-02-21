import java.util.Vector;

public class VectorStack<T> implements UVGStack<T> {
    private Vector<T> stack;

    // Constructor para inicializar la pila
    public VectorStack() {
        this.stack = new Vector<>();
    }

    // Implementación de los métodos de la interfaz UVGStack
    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null; // O manejar de otra manera
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null; // O manejar de otra manera
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

import java.util.ArrayList;

public class ArrayListStack<T> implements UVGStack<T> {
    private ArrayList<T> stack;

    public ArrayListStack() {
        this.stack = new ArrayList<>();
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

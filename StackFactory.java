public class StackFactory {
    public static UVGStack<?> getStack(String type) {
        switch (type) {
            case "arrayList":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "linkedList":
                return new LinkedListStack<>();
            default:
                throw new IllegalArgumentException("Unknown Stack Type");
        }
    }
}
public class Tuple<T, E> {
    private T first;
    private E second;

    public Tuple(T first, E second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + " -> " + second.toString();
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}

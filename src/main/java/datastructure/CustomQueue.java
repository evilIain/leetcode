package datastructure;

import lombok.Getter;
import lombok.Setter;

public class CustomQueue<T> {

    private QueueNode<T> first;
    private QueueNode<T> last;

    @Getter
    @Setter
    private static class QueueNode<T> {

        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (last != null) {
            node.next = last;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new RuntimeException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            return null;
        }
        return first.data;
    }
}

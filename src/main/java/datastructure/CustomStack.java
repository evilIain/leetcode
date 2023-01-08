package datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomStack<T> {

    private StackNode<T> top;

    @Getter
    @Setter
    private static class StackNode<T> {

        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public T pop() {
        if (top == null) {
            throw new RuntimeException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T item) {
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }
}

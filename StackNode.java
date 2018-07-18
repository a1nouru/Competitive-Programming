import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T>{
        private StackNode<T> next;
        private T data;

        public StackNode (T data) {
            this.data = data;
            next = null;
        }

        private StackNode<T> top;

        public T pop(){
            if(top == null) throw new EmptyStackException();

            T item = top.data;
            top = top.next;

            return item;
        }

        public void push(T item){
            StackNode<T> newNode = new StackNode<>(item);
            if(top == null){
                top = newNode;
                newNode.next = null;
            }
            newNode.next = top;
            top = newNode;
        }

        public T peek(){
            if(top == null) throw new EmptyStackException();
            return top.data;
        }
    }

}

import java.util.EmptyStackException;

public class MyQueue<T> {

    public class queueNode<T>{
        queueNode<T> next;
        T data;

        public queueNode(T data){
            this.data = data;
            next = null;
        }
    }

    private queueNode<T> first;
    private queueNode<T> last;

    public void add(T item){
        queueNode<T> new_node = new queueNode<>(item);

        if(first == null){
            first = new_node;
            new_node.next = null;
        }

        new_node.next = last;
        last = new_node;
    }

    public T remove(){
        if(first == null) throw new EmptyStackException();
        T data = first.data;
        first = first.next;

        return data;
    }

    public T peek(){
        if (first== null) throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty(){
        return (first == null);
    }
}

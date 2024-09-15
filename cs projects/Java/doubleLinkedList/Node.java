package doubleLinkedList;
// Author: Idan Alashvili
public class Node<T> {
    private T data;
    private Node<T> previous;
    private Node<T> next;

    /**
     * constructor
     * @param data
     */
    public Node(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    /**
     * get's & set's
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

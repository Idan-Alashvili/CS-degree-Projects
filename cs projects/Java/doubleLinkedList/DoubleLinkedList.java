package doubleLinkedList;
// Assignment: 5
// Author: Idan Alashvili, ID: 326117629
public class DoubleLinkedList<T> implements List<T> {
    private Node<T> headList;
    private Node<T> lastInList;
    /**
     * get's & set's
     */
    public Node<T> getHeadList() {
        return headList;
    }

    public void setHeadList(Node<T> headList) {
        this.headList = headList;
    }

    public Node<T> getLastInList() {
        return lastInList;
    }

    public void setLastInList(Node<T> lastInList) {
        this.lastInList = lastInList;
    }

    public boolean isEmpty() {
        return this.headList == null;
    }

    public int size() {
        int count = 0;
        Node<T> temp = this.headList;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void addFirst(T data) {
        Node<T> FirstNode = new Node<>(data);
        if (this.headList == null) {
            headList = lastInList = FirstNode;
        } else {
            FirstNode.setNext(headList);
            FirstNode.setPrevious(FirstNode);
            headList = FirstNode;
        }
    }

    public void addLast(T data) {
        Node<T> lastNode = new Node<>(data);
        if (this.lastInList == null) {
            headList = lastInList = lastNode;
        } else {
            lastNode.setPrevious(this.lastInList);
            lastNode.setNext(null);
            lastInList.setNext(lastNode);
            this.lastInList = lastNode;
        }
    }

    public T remove(T data) {
        Node<T> temp = this.headList;
        headList.setData(data);
        return temp.getData();
    }

    public void clear() {
        this.headList = this.lastInList = null;
//        if (this.headList == this.lastInList || this.headList == null)return;
//        while (this.headList != null){
//            this.lastInList.setPrevious(lastInList);
//            setLastInList(null);
//        }
    }

    public boolean contains(T data) {
        Node<T> temp = this.headList;
        while (temp != null) {
            if (temp.getData().equals(data)) return true;
            temp = temp.getNext();
        }
        return false;
    }

    public void printForward() {
        Node<T> temp = this.headList;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public void printBackward() {
        Node<T> temp = lastInList;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getPrevious();
        }
    }
}

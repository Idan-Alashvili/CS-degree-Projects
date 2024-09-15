package doubleLinkedList;
// Author: Idan Alashvili
public interface List<T> {
    /**
     * a method that checking if the DoubleLInked list is empty.
     * @return true if empty, else false.
     */
    boolean isEmpty();

    /**
     * checking the size of the DoubleLInked list.
     * @return the number of the size of this DoubleLInked list.
     */
    int size();

    /**
     * adding an object to the head of the DoubleLInked list.
     * @param data
     */
    void addFirst(T data);

    /**
     * adding an object to the end of the DoubleLInked list.
     * @param data
     */
    void addLast(T data);

    /**
     * removing the first object from the DoubleLInked list.
     * @param data
     * @return the DoubleLInked list without the object that removed here.
     */
    T remove(T data);

    /**
     * clearing ALL the DoubleLInked list.
     */
    void clear();

    /**
     * checking if the DoubleLInked list has the object we asking it to check
     * @param data
     * @return true if the DoubleLInked list contains  object, else false.
     */
    boolean contains(T data);

    /**
     * printing the DoubleLInked list from head to end.
     */
    void printForward();

    /**
     * printing the DoubleLInked list from end to head.
     */
    void printBackward();

}

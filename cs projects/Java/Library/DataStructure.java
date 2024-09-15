//Idan Alashvili
package HW1;

import java.util.ArrayList;

public class DataStructure<T> {
    ArrayList<T> dynamicArray = new ArrayList<>();
    private T[] array;
    private int size;
    private int capacity;

    /** Default constructor
     *  Making a dynamic array with the capacity of 50
     */
    public DataStructure() {
        this.capacity = 50;
        this.dynamicArray = new ArrayList<>(capacity);
        this.size = 0;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<T> getDynamicArray() {
        return dynamicArray;
    }

    public void setDynamicArray(ArrayList<T> dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    /**
     * adding data to the dynamic array at given index.
     * @param data - the given data
     * @param index - the place we adding it to the array
     */
    public void add(T data, int index) {
        dynamicArray.add(index, data);
        size++;
    }

    /**
     * adding data to the dynamic array at the end.
     * @param data - the given data.
     */
    public void addToEnd(T data) {
        capacity++;
        dynamicArray.add(capacity - 1, data);
        size++;
    }

    /**
     * deleting the given data at the array.
     * @param data - the given data.
     */
    public void delete(T data) {
        dynamicArray.remove(data);
        size--;
    }

    /**
     * checking if the dynamic array contains the data.
     * @param data - the given data.
     * @return true - if the data is in the array
     *         false - if it isn't.
     */
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) return true;
        }
        return false;
    }

    /**
     * get the size of the dynamic array
     * @return - the size(int).
     */
    public int size() {
        return getSize();
    }

    /**
     * Return the string value of the elements in a data structure from beginning to the end, seperated by commas
     * @return - string
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.size; i++){
            output += this.array[i].toString();
        }
        return output;
    }

}

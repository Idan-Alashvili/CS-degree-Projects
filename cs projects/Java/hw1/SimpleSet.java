package exc1;


import java.util.Arrays;

public class SimpleSet <E> implements Set
{
    private E[] elements;
    private int capacity;
    private int size;

    public SimpleSet(int capacity)
    {
        super();
        this.elements = (E[]) new Object [capacity];
        this.capacity = capacity;
        this.size = 0;

    }

    public SimpleSet()
    {
        this.capacity = 5;
        this.elements = (E[]) new Object [capacity];
        this.size = 0;
    }



    @Override
    public void add(Object e)
    {
        if (!contains(e))
        {
            if (size < capacity)
            {
                elements[size] = (E) e;
                size++;
            }
            else
            {
                capacity += 5;
                E[] newElements = Arrays.copyOf(elements, capacity);
                newElements[size] = (E) e;
                elements = newElements;
                size++;
            }
        }
    }

    int index;

    @Override
    public boolean remove(Object e)
    {
        if(contains(e))
        {
            for(int i = 0; i < size-1; i++)
            {
                if(elements[i].equals(e))
                {
                    index = i;
                    Object temp = elements[capacity-1];
                    elements[capacity-1] = elements[i];
                    elements[capacity-1] = null;
                    elements[i] = null;
                    elements[capacity-1] = (E)temp;
                }
            }

            for(int i = index; i < size-1; i++)
            {
                this.elements[i] = this.elements[i+1];
            }

            elements[size-1] = null;


            this.size--;
            return true;
        }

        return false;
    }



    @Override
    public boolean contains(Object e)
    {
        for(int i = 0; i < size-1; i++)
        {
            if(elements[i].equals(e))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size()
    {
        if(size == 0)
        {
            return 0;
        }

        return size;

    }

    @Override
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }

    public E[] getElements()
    {
        return elements;
    }

    public void setElements(E[] elements)
    {
        this.elements = elements;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}

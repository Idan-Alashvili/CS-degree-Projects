package exc1;


public class SetUtils extends SimpleSet
{
    public static <E> Set<E> union(SimpleSet<E> setA, SimpleSet<E> setB)
    {
        SimpleSet<E> unionSet = new SimpleSet<>();

        for (int i = 0; i < setA.getSize(); i++)
        {
            unionSet.add(setA.getElements()[i]);
        }

        // Add elements from setB
        for (int i = 0; i < setB.getSize(); i++)
        {
            unionSet.add(setB.getElements()[i]);
        }

        return unionSet;

    }

    public static <E> Set<E> intersection(SimpleSet<E> setA, SimpleSet<E> setB)
    {
        SimpleSet<E> intersectionSet = new SimpleSet<>();


        for (int i = 0; i < setA.getSize(); i++)
        {
            E element = setA.getElements()[i];

            if (setB.contains(element))
            {
                intersectionSet.add(element);
            }

        }

        return intersectionSet;

    }

    public static <E> Set<E> difference(SimpleSet<E> setA, SimpleSet<E> setB)
    {
        SimpleSet<E> differenceSet = new SimpleSet<>();

        for (int i = 0; i < setA.getSize(); i++)
        {
            E element = setA.getElements()[i];

            if(!setB.contains(element))
            {
                differenceSet.add(element);
            }

        }

        return differenceSet;
    }

    public static <E> Set<E> symmetricDifference(SimpleSet<E> setA, SimpleSet<E> setB)
    {
        SimpleSet<E> symmetricDifferenceSet = new SimpleSet<>();


        for (int i = 0; i < setA.getSize(); i++)
        {
            E element = setA.getElements()[i];

            if (!setB.contains(element))
            {
                symmetricDifferenceSet.add(element);
            }
        }

        for (int i = 0; i < setB.getSize(); i++)
        {
            E element = setB.getElements()[i];

            if (!setA.contains(element))
            {
                symmetricDifferenceSet.add(element);
            }
        }

        return symmetricDifferenceSet;

    }

}
package exc1;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        // Creating sets
        SimpleSet<Integer> setA = new SimpleSet<>();
        SimpleSet<Integer> setB = new SimpleSet<>();

        // Adding elements to setA
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);

        // Adding elements to setB
        setB.add(6);
        setB.add(7);
        setB.add(8);
        setB.add(9);
        setB.add(10);


        // Displaying initial sets
        System.out.println("exc1.Set A: " + Arrays.toString(setA.getElements()));
        System.out.println("exc1.Set B: " + Arrays.toString(setB.getElements()));

        // Testing union method
        SimpleSet<Integer> unionSet = (SimpleSet<Integer>) SetUtils.union(setA, setB);
        System.out.println("Union: " + Arrays.toString(unionSet.getElements()));

        // Testing intersection method
        SimpleSet<Integer> intersectionSet = (SimpleSet<Integer>) SetUtils.intersection(setA, setB);
        System.out.println("Intersection: " + Arrays.toString(intersectionSet.getElements()));

        // Testing difference method
        SimpleSet<Integer> differenceSet = (SimpleSet<Integer>) SetUtils.difference(setA, setB);
        System.out.println("Difference (A - B): " + Arrays.toString(differenceSet.getElements()));

        // Testing symmetricDifference method
        SimpleSet<Integer> symmetricDifferenceSet = (SimpleSet<Integer>) SetUtils.symmetricDifference(setA, setB);
        System.out.println("Symmetric Difference: " + Arrays.toString(symmetricDifferenceSet.getElements()));

        // Testing remove method
        setA.remove(2);
        System.out.println("exc1.Set A after removing element 2: " + Arrays.toString(setA.getElements()));

        // Testing contains method
        boolean containsElement = setB.contains(4);
        System.out.println("exc1.Set B contains element 4: " + containsElement);

        // Testing size method
        int setSize = setA.size();
        System.out.println("Size of set A: " + setSize);

        // Testing isEmpty method
        boolean emptySet = setB.isEmpty();
        System.out.println("Is set B empty: " + emptySet);
    }
}
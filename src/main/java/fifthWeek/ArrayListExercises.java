package fifthWeek;

import java.util.*;

public class ArrayListExercises {

   static ArrayList<String> colors = new ArrayList<>();
   static LinkedList<String> colors2 = new LinkedList<>();
   static HashSet<Integer> hashSetNumbers = new HashSet<>();

    // 1. Write a Java program to create an array list, add some colors (strings) and print out the collection.
    public void printColorsCollection () {

        colors.add("Lemon");
        colors.add("Orange");
        colors.add("Red");
        colors.add("Brown");
        colors.add("White");
        colors.add("Yellow");
        colors.add("Green");

        System.out.println(colors);
    }

    //2. Write a Java program to iterate through all elements in an array list.
    public void printListElements() {
        // possible to add more elements in the collection.
        for (String color : colors) {
            System.out.println(color);
        }
    }

    //Write a Java program to insert an element into the array list at the first position.
    public void insertElementToFirstPosition() {
        colors.add(0, "Blue");
    }

    // 4. Write a Java program to retrieve an element (at a specified index) from a given array list.
    public void retrieveElement(int element_Index) {
        colors.remove(element_Index);
    }

    //5. Write a Java program to update an array element by the given element.
    public void updateElement(int index, String newElement) {
      colors.set(index, newElement);
    }

    // 6. Write a Java program to remove the third element from an array list.
    public void retrieveElement() {
        colors.remove(2);
    }

    // 7. Write a Java program to search for an element in an array list.
    public String searchForElement(String newElement) {
        String toFind = "";
        for(String color : colors) {
            if (color.equals(newElement)) {
                toFind = color;
                break;
            }
        }

        return toFind;
    }

    // 8. Write a Java program to sort a given array list.
    public void sortArrayList(ArrayList<String> aList) {
        Collections.sort(colors);
    }

    // 9. Write a Java program to copy one array list into another.
    public void copyArrayList(List<String> colors) {
        List<String> newList = new ArrayList<>();
        Collections.copy(newList, ArrayListExercises.colors);
    }

    //10 Write a Java program to shuffle elements in an array list.
    public void shuffleArrayList() {
        Collections.shuffle(colors);
    }

    // 11. Write a Java program to reverse elements in an array list.
    public void reverseArray() {
        Collections.reverse(colors);
    }

    // 12. Write a Java program to extract a portion of an array list.
    public void extractAPorttionOfArray() {
       colors = (ArrayList<String>) colors.subList(0, colors.size()-1);
    }

    // Write a Java program to compare two array lists.
    public Boolean compareArrayList (ArrayList<String> newList) {
       return colors.equals(newList);
    }

    // Write a Java program that swaps two elements in an array list.
    public void swapElement() {
        Collections.swap(colors, 1, 6);
    }

    // 15. Write a Java program to join two array lists.
    //Click me to see the solution
    public void joinArrayList (ArrayList<String> newArrayList, ArrayList<String> oldList) {
        colors.addAll(newArrayList);
        colors.addAll(oldList);
    }

    // 16. Write a Java program to clone an array list to another array list.
    public void clone (ArrayList<String> newArrayList) {
        ArrayList<String> c1;
        c1 = new ArrayList<>(colors);
        System.out.println(c1);
    }

    //17. Write a Java program to empty an array list.
    public void emptyList() {
       colors.clear();
    }

    // 18. Write a Java program to test whether an array list is empty or not.
    public boolean checkIfEmpty() {
        return colors.isEmpty();
    }

    // 19. Write a Java program for trimming the capacity of an array list.
    public void checkCapacity() {
        colors.trimToSize();
    }

    // 20. Write a Java program to increase an array list size.
    public void increaseSize() {
        colors.ensureCapacity(20);
    }


    //21. Write a Java program to replace the second element of an ArrayList with the specified element.
    public void replaceElement() {
        colors.set(1, "newelement");
    }

    // 22. Write a Java program to print all the elements of an ArrayList using the elements' position.
    public void printElementbyCode() {
        for(int i =0; i<colors.size(); ++i) {
            System.out.println(colors.get(i));
        }
    }

    /* LINKEDLIST PROBLEMS STARTS HERE */

   // 1. Write a Java program to append the specified element to the end of a linked list.
    public static void appendToList(String element) {
        colors2.add(element);
    }

    // 2. Write a Java program to iterate through all elements in a linked list.
    public static void iterateLinkedList(String element) {
        for (String s : colors2) {
            System.out.println(s);
        }

        // another way to interate through this LinkedList is to use the Iterator interface
        Iterator<String> cs = colors2.iterator();
        while(cs.hasNext()) {
            System.out.println(cs.next());
        }
    }

    // Write a Java program to iterate through all elements in a linked list starting at the specified position.
    public static void printFromIndex (int index) {
        Iterator<String> colors = colors2.listIterator(index);
        while(colors.hasNext()) {
            System.out.println(colors.next());
        }
    }

    // 4. Write a Java program to iterate a linked list in reverse order.
    //Click me to see the solution

    public static void reversePrint () {
        ListIterator<String> colors = colors2.listIterator();
        while(colors.hasPrevious()) {
            System.out.println(colors.previous());
        }
    }

    // 5. Write a Java program to insert the specified element at the specified position in the linked list.
    //Click me to see the solution
    public static void insertToIndex (int index, String element) {
        colors2.set(index, element);
    }

    // 6. Write a Java program to insert elements into the linked list at the first and last positions.
    public static void insertToIndex (String firstElement, String lastElement) {
        colors2.offerFirst(firstElement);
        colors2.offer(lastElement);
    }

    // 7. Write a Java program to insert the specified element at the front of a linked list.
    public static void insertToIndex2 (String element) {
        colors2.set(0, element);
    }

    // 8. Write a Java program to insert the specified element at the end of a linked list.
    public static void insertToIndex3 (String element) {
        colors2.set(colors.size()-1, element);
    }

    // 9. Write a Java program to insert some elements at the specified position into a linked list.
    //Click me to see the solution
    public static void insertElementToIndexPosition (int index, LinkedList<String> newList) {
        colors2.addAll(index, newList);
    }

    // 10. Write a Java program to get the first and last occurrence of the specified elements in a linked list.
    //Click me to see the solution
    public static void getFirstElementOccurrance (String firstElement, String lastElement) {
        int indexOf = colors2.indexOf(firstElement);
        int c = colors2.lastIndexOf(lastElement);

        colors2.offer(firstElement);

        colors2.get(indexOf);
        colors2.get(c);

    }

    // 11. Write a Java program to display elements and their positions in a linked list.
    public static void showAll() {
        for(int i = 0; i < colors2.size(); ++i) {
            System.out.println((i+1) + " : " + colors2.get(i));
        }
    }

    // 12. Write a Java program to remove a specified element from a linked list.
    //Click me to see the solution
    public static void removeElement(String element) {

        colors2.remove(element);

        // handles case of duplicate
        for(int i = 0; i < colors2.size(); ++i) {
            if(colors2.get(i).equals(element)) colors2.remove(colors2.get(i));
        }
    }

    // 13. Write a Java program to remove the first and last elements from a linked list.
    //Click me to see the solution

    public static void removeElementsFromFirstAndLastPosition () {
        colors2.removeFirst();
        colors2.removeLast();
    }


    // 14. Write a Java program to remove all elements from a linked list.
    public static void removeAllElements() {
       colors2.clear();
    }

    //15. Write a Java program that swaps two elements in a linked list.
    public static void swapSomeElement() {
        Collections.swap(colors2, 0, 5);
    }

    // 16. Write a Java program to shuffle elements in a linked list.
    public static void shuffleIt() {
        Collections.shuffle(colors2);
    }

    // 17. Write a Java program to join two linked lists.
    public static void addTwoLinkedList() {
        LinkedList<String> f1 = new LinkedList<>();
        LinkedList<String> f2 = new LinkedList<>();
        colors2.addAll(f1);
        colors2.addAll(f2);
    }

    // 18. Write a Java program to copy a linked list to another linked list.
    public static void cloneLinkedList() {
        LinkedList<String> f2 = new LinkedList<>();

        f2 = (LinkedList<String>)colors2.clone();
    }

    // 19. Write a Java program to remove and return the first element of a linked list.
    public static String removeFirstElement() {
       // String firstel = colors2.getFirst(); firstel can also be returned
       return  colors2.removeFirst();
    }

    // 20. Write a Java program to retrieve, but not remove, the first element of a linked list.
    public static String removeFirst() {
        return  colors2.getFirst();
    }

    // 21. Write a Java program to retrieve, but not remove, the last element of a linked list.
    public static String getLastElement() {
        return colors2.getLast();
    }

    // 22. Write a Java program to check if a particular element exists in a linked list.
    public static boolean checkIfElementExist(String element) {
        return colors2.contains(element);
    }

    // 23. Write a Java program to convert a linked list to an array list.
    public static void convertList(String element) {
        ArrayList<String> copyTo = new ArrayList<>(List.copyOf(colors2));
    }

    // 24. Write a Java program to compare two linked lists.
    public static void compareList(String element) {
        LinkedList<String> f2 = new LinkedList<>();
        LinkedList<String> f3 = new LinkedList<>();
      // return f2.equals(colors2); then the method should return boolen

       for (int i = 0; i < colors2.size(); ++i) {
           for (int j = 0; j < f2.size() && colors2.get(i).equals(f2.get(j)); ++j) {
               f3.add("Yes");
           }
           f3.add("No");
       }

        System.out.println(f3);
    }

    // 25. Write a Java program to check if a linked list is empty or not.
    public static boolean checkIfListEmpty() {
       return colors2.isEmpty();
    }

    // 26. Write a Java program to replace an element in a linked list.
    public static void replaceElementInLIst() {
        colors2.set(3, "Golden");
    }

    // SOLUTION FOR HASHSET PROBLEMS

    // Java Collection: HashSet Exercises [12 exercises with solution]
    // 1. Write a Java program to append the specified element to the end of a hash set.
    public static void addToHashSet() {
        hashSetNumbers.add(8);
        hashSetNumbers.add(3);
        hashSetNumbers.add(4);
    }

    // 2. Write a Java program to iterate through all elements in a hash list.
    public static void showAllItemsInHashSet() {
        for (Integer s : hashSetNumbers) { // java now allows iteration of elements in List with For Loop
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ArrayListExercises aE = new ArrayListExercises();
        aE.printColorsCollection();
        System.out.println("Colors before shuffle" + colors);
        Collections.shuffle(colors);
        System.out.println("\nColors after shuffle " + colors);
    }

    // 15. Write a Java program that swaps two elements in a linked list.

}

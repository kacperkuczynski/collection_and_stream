package kolekcja.lista.linkedLista;

import java.util.Iterator;
import java.util.LinkedList;

public class Dog {
    private String breed;
    private int age;
    private boolean longHair;

    public Dog(String breed, int age, boolean longHair) {
        this.breed = breed;
        this.age = age;
        this.longHair = longHair;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", age=" + age +
                ", longHair=" + longHair +
                '}';
    }
    //iterator linkedList
    public static void usingIterator(LinkedList<Dog> dogsLinkedList){
        Iterator itr = dogsLinkedList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println();
    }
    //iterator linkedList starting at the specified position.
    public static void usingSpecifyIterator(LinkedList<Dog> dogsLinkedList, int p){
        Iterator itr = dogsLinkedList.listIterator(p);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println();
    }
    //iterator linkedList starting in reverse order.
    public static void usingReverseIterator(LinkedList<Dog> dogsLinkedList){
        Iterator itr = dogsLinkedList.descendingIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Dog> dogsLinkedList = new LinkedList<Dog>();//new linkedList
        //adding elements
        dogsLinkedList.add(new Dog("HUSKY", 2, true));
        dogsLinkedList.add(new Dog("GOLDEN RETRIEVER", 6, true));
        dogsLinkedList.add(new Dog("BORDER COLLIE", 4, true));

        //iterate out
        usingIterator(dogsLinkedList);

        //insert element at the end linkedList
        dogsLinkedList.addLast(new Dog("DOBERMAN", 7, false));

        //iterate linkedList starting at the specified position
        usingSpecifyIterator(dogsLinkedList,2);

        //iterate linkedList starting in reverse order.
        usingReverseIterator(dogsLinkedList);

        //insert element at the specified position in linkedList
        dogsLinkedList.add(1, new Dog("BASENJI", 3, false));

        //insert element at the first position
        dogsLinkedList.addFirst(new Dog("BOXER", 3, false));

        //insert element at the specified position in linkedList
        dogsLinkedList.addLast(new Dog("DALMATIAN", 3, false));

        usingIterator(dogsLinkedList);

        //insert element to front of linkedList
        dogsLinkedList.offerFirst(new Dog("BOLOGNESE", 5, true));

        //insert element at the end of linkedList
        dogsLinkedList.offerLast(new Dog("BRIARD", 5, true));

        usingIterator(dogsLinkedList);

        LinkedList<Dog> anotherDogsLinkedList = new LinkedList<Dog>();//new linkedList
        //adding elements
        anotherDogsLinkedList.add(new Dog("PEKINGESE", 2, true));
        anotherDogsLinkedList.add(new Dog("HAVANESE", 6, true));

        //add all anotherLinkedList to linkedList
        dogsLinkedList.addAll(anotherDogsLinkedList);

        usingIterator(dogsLinkedList);

        //find first element of linkedList
        Object firstElement = dogsLinkedList.getFirst();
        System.out.println("First element of linkedList: " + firstElement);

        //find last element of linkedList
        Object lastElement = dogsLinkedList.getLast();
        System.out.println("Last element of linkedListL " + lastElement);

    }
}

package kolekcja.sety.treeSety;

import java.util.*;

public class Car implements Comparable<Car>{
    private String brand;
    private String model;
    private int power;

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    //iterate through all elements in a tree set
    public static void usingIterator(Set<Car> carTreeSet){
        Iterator itr = carTreeSet.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println();
    }
    public static void descendingIterator(TreeSet<Car> carTreeSet){
        Iterator<Car> itr = carTreeSet.descendingIterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println();
    }
    public int compareTo(Car c) {
        return model.compareTo(c.model);
    }

    public int compareTo1(Car c) {
        return brand.compareTo(c.brand);
    }

    public int compareTo2(Car c) {
        if (power > c.power) return 1;
        else if (power < c.power) return 0;
        else return 0;
    }


    public static void main(String[] args) {
     TreeSet<Car> carsTreeSet = new TreeSet<Car>();//new treeSet
     Car c1 = new Car("FORD","MONDEO", 110);
     Car c2 = new Car("BMW","X4", 120);
     Car c3 = new Car("AUDI","A4", 150);

     //adding element with compareTo
     carsTreeSet.add(c1);
     carsTreeSet.add(c2);
     carsTreeSet.add(c3);

     usingIterator(carsTreeSet);

     //add all the elements to another treeSet
    TreeSet<Car> anotherCarsTreeSet = new TreeSet<>(carsTreeSet);//new treeSet
    anotherCarsTreeSet.add(new Car("VOLVO", "XC40", 130));//adding element
    System.out.println("Another TreeSet: ");
    usingIterator(anotherCarsTreeSet);

    //reverse order view of the elements contained in a given tree set
    System.out.println("Elements in reverse order: ");
    descendingIterator(carsTreeSet);

    //get first element of treeSet
    System.out.println("First element: " + carsTreeSet.first());

    //get last element of treeSet
    System.out.println("Last element: " + carsTreeSet.last());
        System.out.println();

    //clone a tree set list to another tree set
    TreeSet clonedTree = new TreeSet<>();
    clonedTree = (TreeSet) carsTreeSet.clone();
    System.out.println("Cloned treeSet: ");
    usingIterator(clonedTree);

    //get the number of elements in a tree set
    System.out.println("Get number of elements in a treeSet: " + carsTreeSet.size());

    //compare two tree sets
    boolean compare = carsTreeSet.equals(anotherCarsTreeSet);
    System.out.println("Compare two tree set: " + compare);

    //find the car with power bigger than 115 in a tree set
    //#1
    carsTreeSet.stream().filter(c-> c.power > 115).forEach(System.out::println);

    }
}

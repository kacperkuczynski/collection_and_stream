package kolekcja.sety;

import kolekcja.lista.arrayLista.Cars;

import java.util.*;

public class Car {
    private String brand;
    private String model;
    private int power;

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
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

    @Override
    public String toString() {
        return "Car {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
    //iterate through all elements in hash list
    public static void usingIterator(Set<Car> carHashSet){
        Iterator itr = carHashSet.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println();
    }

    public static void main(String[] args) {
        HashSet<Car> carsHashSet = new HashSet<Car>();
        carsHashSet.add(new Car("FORD","MONDEO", 110));
        carsHashSet.add(new Car("VW","PASSAT", 130));
        carsHashSet.add(new Car("BMW","M5", 150));

        //in iterate out date are hashing BMW car change place
        usingIterator(carsHashSet);

        //get number of elements
        System.out.println("Car HashSet size: " + carsHashSet.size());

        //copy carsHashSet to anotherCarsHashSet /1
        HashSet<Car> anotherCarsHashSet1 = new HashSet<Car>(carsHashSet);
        System.out.println("Another 1 car HashSet: ");
        usingIterator(anotherCarsHashSet1);

        //copy carsHashSet to anotherCarsHashSet /2
        HashSet<Car> anotherCarsHashSet2 = new HashSet<Car>();
        anotherCarsHashSet2 = (HashSet<Car>) carsHashSet.clone();
        System.out.println("Another 2 car HashSet: ");
        usingIterator(anotherCarsHashSet2);

        //convert carsHashSet to array
        Car[] array = new Car[carsHashSet.size()];
        carsHashSet.toArray(array);
        System.out.println("Car array converted: ");
        for (Car car : array)
            System.out.println(car);

        //convert carsHashSet to carsArrayList
        ArrayList<Car> carsArrayList = new ArrayList<>(carsHashSet);
        System.out.println("Car ArrayList converted: " + carsArrayList);

        //convert carsHashSet to carsTreeSet using interface Set
        Set<Car> carTreeSet = new TreeSet<>();
        carTreeSet = (Set<Car>) carsHashSet.clone();
        System.out.println("Car TreeSet converted: " + carTreeSet);

        //compare two HashSet anotherCarHashSet1 and anotherCarHashSet2
        boolean result1 = anotherCarsHashSet1.equals(anotherCarsHashSet2);
        System.out.println("The same HashSet1: " + result1);
        anotherCarsHashSet1.add(new Car("RENAULT", "MEGANE", 115));
        boolean result2 = anotherCarsHashSet1.equals(anotherCarsHashSet2);
        System.out.println("The same HashSet2: " + result2);

        //empty hash set
        carsHashSet.removeAll(carsHashSet);
        System.out.println("Car HashSet is empy: " + carsHashSet.isEmpty());
    }
}

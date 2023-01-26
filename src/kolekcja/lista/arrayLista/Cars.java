package kolekcja.lista.arrayLista;

import java.util.*;

public class Cars {
    private String brand;
    private String model;
    private int power;

    public Cars(String brand, String model, int power) {
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
    public static Comparator<Cars> CarBrandComparator = new Comparator<Cars>() {

        // Comparing brand of cars
        public int compare(Cars c1, Cars c2) {
            String CarBrand1
                    = c1.getBrand().toUpperCase();
            String CarBrand2
                    = c2.getBrand().toUpperCase();

            // Returning in ascending order
            return CarBrand1.compareTo(
                    CarBrand2);

            // descending order
            // return
            // CarBrand2.compareTo(CarBrand1);
        }
    };
    //Comparing car power
    public static Comparator<Cars> CarPowerComparator = new Comparator<Cars>() {

        // Method
        public int compare(Cars c1, Cars c2) {

            int power1 = c1.getPower();
            int power2 = c2.getPower();

            // For ascending order
            return power1 - power2;

            // For descending order
            // power2-power1;
        }
    };
    public static void main(String[] args) {
        List<Cars> carsArrayList = new ArrayList<Cars>();//new ArrayList
        //adding elements
        carsArrayList.add(new Cars("FORD","MONDEO", 110));
        carsArrayList.add(new Cars("BMW","X3", 100));
        carsArrayList.add(new Cars("VW","GOLF", 120));

        //print out
        System.out.println("Print out collection " + carsArrayList);
        System.out.println();
        //iterate out
        for(Cars cars:carsArrayList){
            System.out.println("Iterate colection " + cars);
        }
        System.out.println();

        //insert element at the first and fifth position
        carsArrayList.add(0,new Cars("RENAULT", "MEGANE", 50));
        carsArrayList.add(4,new Cars("VOLVO", "XC30", 80));

        //print out
        System.out.println("After insert 2 elements " + carsArrayList);
        System.out.println();

        //retive element at the specify index
        Cars element;
        element = carsArrayList.get(3);
        System.out.println("Retrive element at the specify index " + element);
        element = carsArrayList.get(4);
        System.out.println("Retrive element at the specify index " + element);
        System.out.println();

        //update specific array element by given element
        carsArrayList.set(0, new Cars("AUDI","A4", 110));
        carsArrayList.set(1, new Cars("KIA","SPORT",180));

        //print out
        System.out.println("After update " + carsArrayList);
        System.out.println();

        //remove third element of arrayList
        carsArrayList.remove(2);

        //print out
        System.out.println("After removing " + carsArrayList);
        System.out.println();

        //search an element in arrayList
        for (Cars cars: carsArrayList){
            if (cars.getModel().contains("GOLF")){
                System.out.println("Found it! This is GOLF! brand = " + cars.getBrand());
            }
        }
        System.out.println();

        //sorting by car brand
        Collections.sort(carsArrayList, Cars.CarBrandComparator);

        System.out.println("Iterate collection sorting by brand");
        //iterate out
        for(Cars cars:carsArrayList){
            System.out.println(cars);
        }
        System.out.println();

        //sorting by car power
        Collections.sort(carsArrayList, Cars.CarPowerComparator);

        System.out.println("Iterate collection sorting by power");
        //iterate out
        for(Cars cars:carsArrayList){
            System.out.println(cars);
        }
        System.out.println();

        System.out.println("Copied first arrayList to second arrayList");
        //new ArrayList
        List<Cars> anotherCarsArrayList = new ArrayList<Cars>();

        //method copy
        anotherCarsArrayList.addAll(carsArrayList);

        System.out.println("Copied arrayList");
        for(Cars cars:anotherCarsArrayList){
            System.out.println(cars);
        }
        System.out.println();

        System.out.println("Original arrayList");
        for(Cars cars:carsArrayList){
            System.out.println(cars);
        }
        System.out.println();

        //Random class to shuffle arrayList
        Random r1 = new Random();
        //method shuffle
        Collections.shuffle(anotherCarsArrayList, r1);

        System.out.println("Shuffled arrayList by Random class");
        for(Cars cars:anotherCarsArrayList){
            System.out.println(cars);
        }
        System.out.println();
    }
}

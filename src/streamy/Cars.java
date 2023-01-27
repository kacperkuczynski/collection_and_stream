package streamy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {
    private String brand;
    private String model;
    private String fuel;
    private int power;
    private int cost;

    public Cars(String brand, String model, String fuel, int power, int cost) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.power = power;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", power=" + power +
                ", cost=" + cost +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuel() {
        return fuel;
    }

    public int getPower() {
        return power;
    }

    public int getCost() {
        return cost;
    }

    public static void main(String[] args) {
        List<Cars> carsList = Arrays.asList(
                new Cars("Audi","e-tron GT","hybrid",590,594000),
                new Cars("Ford","Mustang","petrol",450, 264000),
                new Cars("Volvo","XC90 Recharge","hybrid",550,403400),
                new Cars("Volvo","S90 Recharge","hybrid",450,323900),
                new Cars("Ford","Explorer","hybrid",457,424000),
                new Cars("Audi","A3","diesel",150,110000),
                new Cars("Audi","Q5","diesel",230, 254000),
                new Cars("Audi","A7","petrol", 300, 410000),
                new Cars("BMW","i3","electricity",170, 139000),
                new Cars("BMW","M4 Cabrio","petrol", 250, 345000),
                new Cars("Ford","Focus", "petrol", 280, 145000),
                new Cars("Ford","Fiesta","diesel",125, 86800),
                new Cars("Skoda","Fabia","petrol", 110, 66400),
                new Cars("Skoda","Scala", "diesel", 150, 82400),
                new Cars("BMW","X3", "hybrid",653,935000),
                new Cars("BMW","M5","petrol", 480, 618500),
                new Cars("Skoda","Kamiq","petrol", 150, 101400),
                new Cars("Skoda","Superb","petrol", 200, 142250),
                new Cars("Volvo","C40 Recharge","hybrid",300,256900),
                new Cars("Volvo","XC60","hybrid",240,211900)
        );
        //print out
        carsList.stream().forEach(System.out::println);
        System.out.println();

        //#1 obtain all cars with fuel hybrid
        List<Cars> carsHybrid = carsList.stream()
                .filter(c -> c.getFuel().equalsIgnoreCase("hybrid"))
                .collect(Collectors.toList());
        System.out.println("Car with fuel hybrid:");
        carsHybrid.stream().forEach(System.out::println);
        System.out.println();

        //#2 obtain all car models starting with the letter x
        List<String> modelsLetterX = carsList.stream()
                .filter(l -> l.getModel().startsWith("X"))
                .map(m -> m.getModel().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Car models starting with the letter x:");
        modelsLetterX.stream().forEach(System.out::println);
        System.out.println();

        //#3 obtain all cars with category fuel hybrid and cost less than 300k
        List<Cars> hybridAndCost300 = carsList.stream()
                .filter(f -> f.getFuel().equalsIgnoreCase("hybrid"))
                .filter(c -> c.getCost() < 300000)
                .collect(Collectors.toList());
        System.out.println("Cars with category fuel hybrid and cost less than 300k:");
        hybridAndCost300.stream().forEach(System.out::println);
        System.out.println();

        //#4 obtain all cars with category fuel "petrol"
        List<Cars> fuelPetrol = carsList.stream()
                .filter(f -> f.getFuel().equalsIgnoreCase("petrol"))
                .collect(Collectors.toList());
        System.out.println("Cars with category fuel petrol:");
        fuelPetrol.stream().forEach(System.out::println);
        System.out.println();

        //#5 obtain all cars with category fuel "diesel" and then apply 10% discount
//        List<Cars> dieselAndDiscount = carsList.stream()
//                .map(c -> c.getCost() * 0.9)
//                .collect(Collectors.toList());
//        System.out.println("Cars with category fuel diesel apply 10% discount:");
//        dieselAndDiscount.stream().forEach(System.out::println);
//        System.out.println();
        //#6 get cheapest product of "hybrid" fuel, "petrol" fuel and "diesel" fuel

        Optional<Cars> cheapestByFuelHybrid = carsList.stream()
                .filter(c -> c.getFuel().equalsIgnoreCase("hybrid"))
                .sorted(Comparator.comparing(Cars::getCost))
                .findFirst();
        System.out.println();
        System.out.println("Cheapest car by fuel hybrid: " + cheapestByFuelHybrid);

        //#7 get cheapest product of all category brand
        Optional<Cars> cheapestCar = carsList.stream()
                .sorted(Comparator.comparing(Cars::getCost))
                .findFirst();
        System.out.println();
        System.out.println("Cheapest car of all brand: " + cheapestCar);

        //#8 calculate sum of product by brand BMW
        int sumProductBMW = carsList.stream()
                .filter(c -> c.getBrand() == "BMW")
                .mapToInt(c-> c.getCost())
                .sum();
        System.out.println();
        System.out.println("Sum of product by brand BMW: " + sumProductBMW);

        //#9 calculate average price of all product by fuel diesel in list
        double averagePrice = carsList.stream()
                .filter(c -> c.getFuel().equalsIgnoreCase("diesel"))
                .mapToDouble(Cars::getCost)
                .average().getAsDouble();
        System.out.println();
        System.out.println("Average of price by fuel diesel: " + averagePrice);

        //#10 get most expensive product by brand
        Optional<Cars> mostExpenisve = carsList.stream()
                .sorted(Comparator.comparing(Cars::getCost).reversed())
                .findFirst();
        System.out.println();
        System.out.println("Most expensive car : " + mostExpenisve);
    }
}

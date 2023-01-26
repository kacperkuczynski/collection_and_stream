package streamy;

import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        List<Cars> carsList = Arrays.asList(
                new Cars("Audi","e-tron GT","electricity",590,594000),
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
                new Cars("BMW","XM", "hibrid",653,935000),
                new Cars("BMW","M5","petrol", 480, 618500),
                new Cars("Skoda","Kamiq","petrol", 150, 101400),
                new Cars("Skoda","Superb","petrol", 200, 142250),
                new Cars("Volvo","C40 Recharge","hybrid",300,256900),
                new Cars("Volvo","XC60","hybrid",240,211900)
        );
        carsList.stream().forEach(System.out::println);
    }
}

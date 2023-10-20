import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        HotDrink hotTeaSmall = new HotTea("Майский", 25, 150, 82);
        HotDrink hotCoffeeMedium = new HotCoffee("1984", 1300, 250, 75);
        HotDrink hotChocolateLarge = new HotChocolate("Бабаевский", 333, 400, 85);

        VendingMachine hotDrinksVending = new HotDrinksVendingMachine();

        hotDrinksVending.addProduct(hotTeaSmall);
        hotDrinksVending.addProduct(hotCoffeeMedium);
        hotDrinksVending.addProduct(hotChocolateLarge);

        System.out.println(hotDrinksVending.getProduct("1984"));
        System.out.println(hotDrinksVending.getProduct("Бабаевский", 400, 85));
    }
}
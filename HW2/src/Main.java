

public class Main {
    public static void main(String[] args) {


        Market market = new Market();

        market.update();

        Human human1 = new Human("Johnny Sins", 45, "California");
        Human human2 = new Human("Jason Statham", 50, "London");
        Human human3 = new Human("Dwayne Johnson", 51, "Hayward");
        Human human4 = new Human("Vin Diesel", 56, "Alameda");
        Human human5 = new Human("Bruce Willis", 68, "Oberstein");

        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);
        market.acceptToMarket(human4);
        market.acceptToMarket(human1);
        market.acceptToMarket(human5);

        market.update();

        human1.setMakeOrder();
        human2.setMakeOrder();
        human3.setMakeOrder();
        human4.setMakeOrder();

        market.update();

        human4.setTakeOrder();
        human1.setTakeOrder();

        market.update();

        market.update();

    }
}
public abstract class HotDrink extends Product {

    private int volume;
    private int temp;

    public HotDrink(String name, double cost, int volume, int temp) {
        super(name, cost);
        this.volume = volume;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Горячий напиток " + getName() +
                ", цена=" + getCost() +
                ", объем=" + getVolume() +
                ", температура=" + getTemp() +
                '}';
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
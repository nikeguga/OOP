public class Human extends Actor {

    private int age;
    private String address;

    public Human(String name, int age, String address) {
        super(name);
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("User: %s Age %s Address: %s%n" +
                        "Status: %s%n",
                name,
                age,
                address,
                orderStatus());
    }

    public String orderStatus() {
        if (isTakeOrder) {
            return "Order received";
        }
        if (isMakeOrder) {
            return "Order placed";
        }
        return "There is no order, you scum";
    }

}
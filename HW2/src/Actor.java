public abstract class Actor implements ActorBehaviour {

    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public Actor(String name) {
        this.name = name;
    }

    abstract String getName();

    @Override
    public void setMakeOrder() {
        System.out.println("User: " + name + " -> Order placed");
        isMakeOrder = true;
    }

    @Override
    public void setTakeOrder() {
        System.out.println("User: " + name + " -> Order received");
        isTakeOrder = true;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

}
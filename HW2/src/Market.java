import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {

    private final List<Actor> actors;

    public Market() {
        actors = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        boolean isNameFound = false;
        for (Actor actorInList : actors) {
            if ((actorInList instanceof Human)
                    && ((Human) actorInList).getName().equals(((Human) actor).getName())) {
                System.out.printf("User: %s already has access to marketplace%n",
                        (((Human) actor).getName()));
                isNameFound = true;
                break;
            }
        }
        if (!isNameFound && actor instanceof Human) {
            actors.add(actor);
            System.out.printf("User: %s -> received access on marketplace%n",
                    (((Human) actor).getName()));
        }
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actorInList : actors) {
            if (actorInList.isTakeOrder()) {
                System.out.printf("User: %s -> received order and was unloaded from marketplace%n",
                        (((Human) actorInList).getName()));
            }
        }
    }

    @Override
    public void update() {
        int lineWidth = 60, counter = 1;
        String lineChar = "-";
        System.out.println();
        System.out.println(lineChar.repeat(lineWidth));
        System.out.println("Condition of marketplace: ");
        for (Actor actor : actors) {
            if (actor instanceof Human) {
                takeInQueue(actor);
            }
        }
        takeOrders();
        giveOrders();
        System.out.println(lineChar.repeat(lineWidth));
        System.out.printf("| %-2s| %-18s | %-14s | %-14s |%n", "№", "Username", "Order placed", "Order received");
        System.out.println(lineChar.repeat(lineWidth));
        for (Actor actor : actors) {
            System.out.printf("| %-2s| %-18s |", counter, ((Human) actor).getName());
            if (actor.isMakeOrder()) {
                System.out.printf(" %7s%8s|", "+", " ");
            } else {
                System.out.printf(" %15s|", " ");
            }
            if (actor.isTakeOrder()) {
                System.out.printf(" %7s%8s|", "+", " ");
            } else {
                System.out.printf(" %15s|", " ");
            }
            System.out.printf("%n");
            counter++;
        }
        System.out.println(lineChar.repeat(lineWidth));
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        boolean isUserFound = false;
        for (Actor actorInList : actors) {
            if ((actorInList instanceof Human)
                    && actorInList.getName().equals(((Human) actor).getName())
                    && actor.isMakeOrder()) {
                System.out.printf("User: %s -> Order in queue%n",
                        (((Human) actor).getName()));
                isUserFound = true;
                break;
            }
            if ((actorInList instanceof Human)
                    && ((Human) actorInList).getName().equals(((Human) actor).getName())) {
                System.out.printf("User: %s -> No order -> Not in queue%n",
                        (((Human) actor).getName()));
                isUserFound = true;
                break;
            }
        }
        if (!isUserFound && actor instanceof Human) {
            System.out.printf("User: %s not found%n",
                    (((Human) actor).getName()));
        }
    }

    @Override
    public void takeOrders() {
        boolean isUserFound = false;
        for (Actor actor : actors) {
            if ((actor instanceof Human) && actor.isMakeOrder()) {
                System.out.printf("User: %s -> order was received by marketplace%n",
                        (((Human) actor).getName()));
                isUserFound = true;
            }
        }
        if (!isUserFound) {
            System.out.println("Receiving orders -> No unprocessed orders");
        }
    }

    @Override
    public void giveOrders() {
        boolean isUserFound = false;
        for (Actor actor : actors) {
            if ((actor instanceof Human)
                    && actor.isMakeOrder()
                    && !actor.isTakeOrder()) {
                System.out.printf("User: %s -> Order is ready for handover%n",
                        (((Human) actor).getName()));
                isUserFound = true;
            }
        }
        if (!isUserFound) {
            System.out.println("Order handovers -> No unprocessed orders");
        }
    }

    @Override
    public void releaseFromQueue() {
        for (int i = actors.size() - 1; i >= 0; i--) {
            if ((actors.get(i) instanceof Human) && actors.get(i).isTakeOrder()) {
                System.out.printf("User: %s -> Order was received ny client%n",
                        (((Human) actors.get(i)).getName()));
                System.out.printf("User: %s -> Deleted from queue%n",
                        (((Human) actors.get(i)).getName()));
                actors.remove(actors.get(i));
            }
        }
    }
}
package data;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {
   /*DIP — Dependency Inversion
    Top-level modules should not depend on lower-level modules, but should depend on abstractions.
    The StudentGroupIterator class (lower level module) uses the Iterator interface,
    accepts a list of students (highest level module), the interface establishes a connection between these 2 classes.
    */

    @Override
    public int compare(T o1, T o2) {
        int resultOfComparing = o1.getSecondName().compareTo(o2.getSecondName());
        if (resultOfComparing == 0) {
            resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());
            if (resultOfComparing == 0) {
                return o1.getPatronymic().compareTo(o2.getPatronymic());
            } else {
                return resultOfComparing;
            }
        } else {
            return resultOfComparing;
        }
    }
}
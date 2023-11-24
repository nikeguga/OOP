package data;

import java.util.Iterator;
import java.util.List;

public class StudentGroupIterator implements Iterator<Student> {
    /*DIP — Dependency Inversion
    Top-level modules should not depend on lower-level modules, but should depend on abstractions.
    The StudentGroupIterator class (lower level module) uses the Iterator interface,
    accepts a list of students (highest level module), the interface establishes a connection between these 2 classes.
    */
    private int counter;
    private final List<Student> students;

    /*constructor*/
    public StudentGroupIterator(StudentGroup studentGroup) {
        this.students = studentGroup.getStudents();
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < students.size() - 1;
    }

    /*SRP – Single Responsibility
     * single class is responsible for single operation, comparison is implemented */

    @Override
    public Student next() {
        if (!hasNext()){
            return null;
        }
        counter++;
        return students.get(counter);
    }
}
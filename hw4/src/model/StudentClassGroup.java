package model;

import lombok.Getter;
import lombok.ToString;
import service.iterator.StudentClassGroupIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class StudentClassGroup implements Iterable<StudentClass> {

    private final List<StudentClass> studentClass;

    public StudentClassGroup() {
        this.studentClass = new ArrayList<>();
    }

    @Override
    public Iterator<StudentClass> iterator() {
        return new StudentClassGroupIterator(studentClass);
    }
}

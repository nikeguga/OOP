package data;

import java.time.LocalDate;
import java.util.Comparator;

public class Teacher extends User{

    private Long teacherId;
    /*OCP — Open-Closed
     * the Student class is a descendant of the User class. It extends the descendant class by adding a new field
     * private Long studentId;
     * the increase in functionality is due to expansion, and not due to modification of the User class
     * */

    /*constructor*/
    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        super(firstName, secondName, patronymic, dateOfBirth);
    }

    /*getters and setters*/
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /*SRP – Single Responsibility
     * single class is responsible for single operation, comparison is implemented. */

    public static class TeacherComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}
package data;

import java.time.LocalDate;

public class Student extends User implements Comparable<Student>{
    /*OCP — Open-Closed
     * the Student class is a descendant of the User class. It extends the descendant class by adding a new field
     * private Long studentId;
     * the increase in functionality is due to expansion, and not due to modification of the User class
     * */
    private Long studentId;


    /*constructor*/
    public Student(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        super(firstName, secondName, patronymic, dateOfBirth);
    }
    /*override with placing studentId*/

    public Student(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, Long studentId) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.studentId = studentId;
    }

    /*getters and setters*/
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }



    /*overriding method toString()*/
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId +'\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", patronymic='" + super.getPatronymic() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                '}';
    }


    /*SRP – Single Responsibility
     * single class is responsible for single operation, comparison is implemented.
     * */

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
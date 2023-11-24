package service;

import java.time.LocalDate;
import java.util.List;

public interface UserService<T> {
    /*ISP — Interface Segregation
    StudentService executes one UserService interface and does the only thing that is required
     */
    List<T> getAll();
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}
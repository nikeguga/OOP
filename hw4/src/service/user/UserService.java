package service.user;

import model.Student;
import model.User;

import java.util.List;

public interface UserService<T extends User> {

    void create(String fullName, Integer age, String phoneNumber);

    void createRandom(Integer quantity);

    List<T> getAll();

    List<T> getAllUsersSortedByFirstName();

    List<T> getAllUsersSortedByLastName();

    List<T> getAllUsersSortedByAge();

    List<T> getAllUsersSortedById();

    void remove(String fullName);

    void edit(String fullName, Integer age, String phoneNumber);

    List<T> getAvailableUsers();
}
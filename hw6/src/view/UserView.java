package view;

import data.User;

import java.util.List;

public interface UserView<T extends User>{
    /*ISP — Interface Segregation
    StudentService executes one UserService interface and does the only thing that is required
     */
    void sendOnConsole(List<T> list);
}
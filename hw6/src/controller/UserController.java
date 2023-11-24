package controller;

import data.User;

import java.time.LocalDate;

public interface UserController<T extends User>{
    /*ISP — Interface Segregation
     * interface executes one action - create
     * */

    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}


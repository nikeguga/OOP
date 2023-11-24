import controller.StudentController;
import controller.UserController;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.create("Shawshank", "Kingovich", "Flagg", 1082, 1, 1);

        /*LSP  Parent and descendant can be used the same way without causing program failure
//        */
        UserController userController = new StudentController();
        userController.create("It", "Kingovich", "Pennywise", 1082,11,11);
    }
}

import service.init.Initializer;
import service.randomizer.StudentClassGroupRandomizer;
import view.SortType;
import view.StudentClassView;
import view.StudentView;
import view.TeacherView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Initializer init = new Initializer();
        StudentClassGroupRandomizer studentClassGroupRandomizer = init.getStudentClassGroupRandomizer();
        StudentView studentView = init.studentView;
        TeacherView teacherView = init.teacherView;
        StudentClassView classView = init.studentClassView;

        // Генерим преподов и студентов
        studentView.createRandom(12);
        studentView.sendOnConsole(SortType.ID);
        teacherView.createRandom(3);
        teacherView.sendOnConsole(SortType.ID);

        // Генерим группу и наполняем
        classView.createAndPopulate("Пингвинята");
        classView.sendOnConsole(SortType.TEAM_ID);

        // Увеличим лимит
        classView.setStudentClassTeacherLimitById(1L, 2);
        classView.sendOnConsole(SortType.TEAM_ID);

        // Подгружаем названия
        classView.load();
        classView.sendOnConsole(SortType.TEAM_ID);

        // Пополняем
        studentView.create("Паук Троицкий", 57, "666-1313");
        studentView.createRandom(280);
        teacherView.createRandom(12);

        // Рандомно заполним группы
        studentClassGroupRandomizer.populateAllStudentClasses();
        classView.sendOnConsole(SortType.TEAM_ID);

        // Ищем Паука, например
        classView.sendOnConsole(SortType.NONE, "Паук Троицкий");
    }
}


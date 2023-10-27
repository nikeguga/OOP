import controller.StudentController;
import controller.TeacherController;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.StudentService;
import service.TeacherService;
import view.SortType;
import view.StudentView;
import view.TeacherView;


public class Main {
    public static void main(String[] args) {
        StudentView studentView = getStudentView();
        TeacherView teacherView = getTeacherView();

        studentView.create("Gold Digger", 19, "777-7777");
        studentView.create("Subject Matter", 180, "111-1111");
        studentView.create("Subject Matter", 180, "111-1111");
        studentView.create("Zero Sub", 10, "000-0000");
        studentView.create("SweetHome Alabama", 65, "123-4567");
        studentView.create("Bulgur Smart", 18, "333-2222");

        studentView.sendOnConsole(SortType.AGE);

        teacherView.create("Hermit Frog", 12, "552-1234");
        teacherView.create("Hermit Frog", 12, "552-1234");
        teacherView.create("Chinga Chgook", 54, "101-6911");
        teacherView.create("Killer Ficha", 17, "888-9898");
        teacherView.create("Sublime Goose", 33, "333-3131");

        teacherView.sendOnConsole(SortType.ID);

        teacherView.edit("Killer Ficha", 47, "888-9898");
        teacherView.sendOnConsole(SortType.ID);

        studentView.edit("Subject Matter", 180, "111-1111");
        studentView.edit("Subject Matter", 18, "111-1111");
        studentView.sendOnConsole(SortType.AGE);

    }

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }

    private static TeacherView getTeacherView() {
        TeacherRepository repository = new TeacherRepository();
        TeacherService service = new TeacherService(repository);
        TeacherController controller = new TeacherController(service);
        return new TeacherView(controller);
    }
}

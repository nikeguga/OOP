import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserDataProcessor {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в произвольном порядке, разделенные пробелом:");
            String userData = scanner.nextLine();
            processUserData(userData);
            System.out.println("Данные успешно обработаны и записаны в файл.");
        } catch (InvalidDataException | IOException | ParseException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void processUserData(String userData) throws InvalidDataException, IOException, ParseException {
        String[] dataParts = userData.split("\\s+");

        if (dataParts.length != 6) {
            throw new InvalidDataException("Неверное количество данных. Пожалуйста, введите все требуемые данные.");
        }

        Person person = createPerson(dataParts);
        validateAndWriteToFile(person);
    }

    private static Person createPerson(String[] dataParts) throws ParseException, InvalidDataException {
        String lastName = dataParts[0];
        String firstName = dataParts[1];
        String middleName = dataParts[2];
        String birthDate = dataParts[3];
        String phoneNumber = dataParts[4];
        String gender = dataParts[5];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(birthDate);

        return new Person(lastName, firstName, middleName, date, phoneNumber, gender);
    }

    private static void validateAndWriteToFile(Person person) throws IOException, InvalidDataException {
        // Дополнительные проверки формата данных
        person.validate();

        // Создание строки для записи в файл
        String fileContent = person.toString();

        // Запись данных в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(person.getLastName() + ".txt", true))) {
            writer.write(fileContent);
            writer.newLine();
        }
    }

    private static class Person {
        private String lastName;
        private String firstName;
        private String middleName;
        private Date birthDate;
        private String phoneNumber;
        private String gender;

        public Person(String lastName, String firstName, String middleName, Date birthDate, String phoneNumber, String gender) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.birthDate = birthDate;
            this.phoneNumber = phoneNumber;
            this.gender = gender;
        }

        public String getLastName() {
            return lastName;
        }

        public void validate() throws InvalidDataException {
            // Дополнительные проверки формата даты, номера телефона и пола
            // ...

            // Пример: Проверка формата номера телефона
            if (!phoneNumber.matches("\\d+")) {
                throw new InvalidDataException("Неверный формат номера телефона. Используйте только цифры.");
            }
        }

        @Override
        public String toString() {
            // Формирование строки для записи в файл
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            return lastName + " " + firstName + " " + middleName + " " +
                    dateFormat.format(birthDate) + " " + phoneNumber + " " + gender;
        }
    }

    private static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}

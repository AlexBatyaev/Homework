import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main {

    // Класс Student
    public static class Student {
        private String name;
        private String group;
        private int course;
        private Map<String, Integer> grades; // Предметы и их оценки

        public Student(String name, String group, int course, Map<String, Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public int getCourse() {
            return course;
        }

        public double getAverageGrade() {
            if (grades.isEmpty()) return 0.0;

            double sum = 0;
            for (int grade : grades.values()) {
                sum += grade;
            }
            return sum / grades.size();
        }

        public void promote() {
            this.course++;
        }
    }

    // Класс StudentManager
    public static class StudentManager {
        private Set<Student> students = new HashSet<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudentsWithLowAverageGrade() {
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getAverageGrade() < 3.0) {
                    iterator.remove();
                }
            }
        }

        public void promoteStudents() {
            for (Student student : students) {
                if (student.getAverageGrade() >= 3.0) {
                    student.promote();
                }
            }
        }

        public void printStudents(int course) {
            for (Student student : students) {
                if (student.getCourse() == course) {
                    System.out.println(student.getName());
                }
            }
        }
    }

    // Класс PhoneBook
    public static class PhoneBook {
        private HashMap<String, List<String>> contacts;

        public PhoneBook() {
            this.contacts = new HashMap<>();
        }

        public void add(String surname, String phoneNumber) {
            contacts.putIfAbsent(surname, new ArrayList<>());
            contacts.get(surname).add(phoneNumber);
        }

        public List<String> get(String surname) {
            return contacts.getOrDefault(surname, new ArrayList<>());
        }
    }

    // Основной метод
    public static void main(String[] args) {
        // Пример использования класса Student и StudentManager
        StudentManager manager = new StudentManager();

        // Пример добавления студентов
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 4);
        grades1.put("History", 5);

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 2);
        grades2.put("History", 3);

        manager.addStudent(new Student("Alice", "Group A", 1, grades1));
        manager.addStudent(new Student("Bob", "Group B", 1, grades2));

        // Удаление студентов с низким средним баллом
        manager.removeStudentsWithLowAverageGrade();

        // Перевод студентов на следующий курс
        manager.promoteStudents();

        // Печать студентов по курсу
        System.out.println("Студенты на курсе 1:");
        manager.printStudents(1);

        // Пример использования телефонного справочника PhoneBook
        PhoneBook phoneBook = new PhoneBook();

        // Добавление записей
        phoneBook.add("Ivanov", "12345");
        phoneBook.add("Ivanov", "67890");
        phoneBook.add("Petrov", "54321");

        // Поиск номера по фамилии
        System.out.println("Номера телефонов Иванова: " + phoneBook.get("Ivanov"));
        System.out.println("Номера телефонов Петрова: " + phoneBook.get("Petrov"));
        System.out.println("Номера телефонов Сидорова: " + phoneBook.get("Sidorov")); // Печатается пустой список
    }
}
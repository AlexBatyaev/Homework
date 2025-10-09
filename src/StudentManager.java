import java.util.*;

class StudentManager {

    public static void removePoorStudents(Collection<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void transferToNextCourse(Student student) {
        if (student.getAverageGrade() >= 3) {
            student.setCourse(student.getCourse() + 1);
            System.out.println("Студент " + student.getName() + " переведен на " + student.getCourse() + " курс.");
        } else {
            System.out.println("Студент " + student.getName() + " не переведен, средний балл ниже 3.");
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Математика", 4);
        grades1.put("Физика", 3);
        grades1.put("Информатика", 5);

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Математика", 2);
        grades2.put("Физика", 2);
        grades2.put("Информатика", 3);

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Математика", 5);
        grades3.put("Физика", 5);
        grades3.put("Информатика", 5);


        Set<Student> students = new HashSet<>();
        students.add(new Student("Иван Иванов", "Группа 1", 1, grades1));
        students.add(new Student("Петр Петров", "Группа 2", 2, grades2));
        students.add(new Student("Анна Сидорова", "Группа 1", 1, grades3));

        System.out.println("Исходный список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        removePoorStudents(new ArrayList<>(students));
        System.out.println("\nСписок студентов после удаления неуспевающих:");
        for (Student student : students) {
            System.out.println(student);
        }


        for (Student student : students) {
            transferToNextCourse(student);
        }

        System.out.println("\nСписок студентов после перевода на следующий курс:");
        for (Student student : students) {
            System.out.println(student);
        }


        printStudents(students, 2);
    }
}
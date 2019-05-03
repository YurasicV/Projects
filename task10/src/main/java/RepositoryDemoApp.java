import objects.Group;
import objects.Student;
import repository.database.DatabaseDAO;
import repository.entity.EntityDAO;
import repository.factory.DatabaseFactory;
import repository.factory.DatabaseType;

public class RepositoryDemoApp {
    public static void main(String[] args) {
        DatabaseDAO database = DatabaseFactory.getDatabaseDAO(DatabaseType.RAM);
        EntityDAO<Student> students = database.getEntityDAO();
        doSomething(students);

//        students = DatabaseFactory.<Student>getStorage(DatabaseType.JSON);
//        doSomething(students);
    }

    private static void doSomething(EntityDAO<Student> students) {
        Group group = new Group(1, "Dp-163Java");
        Student student1 = new Student(1, "Ivanov", group);
        Student student2 = new Student(2, "Petrov", group);
        Student student3 = new Student(3, "Sidorov", group);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student3);

        group.setName("Dp-163Python");
        student2.setName("Vasechkin");
        printStudents(students);

        students.update(student2);
        printStudents(students);

        students.delete(student2);
        printStudents(students);

        Student student = students.get(1);
        printStudent(student);
    }

    private static void printStudents(EntityDAO<Student> students) {
        System.out.println("----Students----");
        students.getAll().forEach((k, v) -> RepositoryDemoApp.printStudent(v));
        System.out.println("---------------");
    }

    private static void printStudent(Student student) {
        System.out.println("Student -> id=" + student.getId() + ", name=" + student.getName()
                + ", group=" + student.getGroup().getName());
    }
}

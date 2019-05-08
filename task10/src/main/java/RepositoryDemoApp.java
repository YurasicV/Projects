import objects.Group;
import objects.Student;
import repository.database.DatabaseDAO;
import repository.entity.EntityDAO;
import repository.factory.DatabaseFactory;
import repository.factory.DatabaseType;
import ui.ConsoleInterface;
import ui.UserInterface;

public class RepositoryDemoApp {
    public static void main(String[] args) {
        UserInterface ui = new ConsoleInterface();

        DatabaseDAO database = DatabaseFactory.getDatabaseDAO(DatabaseType.RAM);

        EntityDAO<Group> groups = database.getEntityDAO(Group.class);
        EntityDAO<Student> students = database.getEntityDAO(Student.class);

        ui.print("Add group");
        Group group = new Group(1, "Dp-163Java");
        groups.add(group);
        ui.print(groups);

        ui.print("Add students");
        Student student1 = new Student(1, "Ivanov", group);
        Student student2 = new Student(2, "Petrov", group);
        Student student3 = new Student(3, "Sidorov", group);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student3);
        ui.print(students);

        ui.print("Rename group");
        group.setName("Dp-163Python");
        groups.update(group);
        ui.print(group);
        ui.print(students);

        ui.print("Rename student");
        student2.setName("Vasechkin");
        students.update(student2);
        ui.print(students);

        ui.print("Delete student");
        students.delete(student3);
        ui.print(students);

        ui.print("Extract student id=1");
        Student student = students.get(1);
        ui.print(student);
    }
}

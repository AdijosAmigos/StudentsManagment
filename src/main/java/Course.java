import java.util.ArrayList;
import java.util.List;

public class Course {
    private final int id;
    private final String name;
    private final List<User> students;


    public Course(int id, String name) {

        this(id, name, new ArrayList<>());

    }

    public Course(int id, String name, List<User> students) {

        if (id < 0) {
            throw new IllegalArgumentException("Course ID must be greater od equal to 0");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Your course name length must be greater than one character");
        }

        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getStudents() {
        return students;
    }

    void addStudent(User user) {
        if (!(user.getType() == UserType.STUDENT)) {
            throw new IllegalArgumentException();
        }
        students.add(user);

    }
}

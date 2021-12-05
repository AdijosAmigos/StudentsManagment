import java.util.List;

public class Course {
    private final int id;
    private final String name;
    private final List<User> students;


//  TODO: dopisac walidacje id oraz name (zaimplementowac + testy)
//  TODO: dopisac testy

    public Course(int id, String name, List<User> students) {

        if (id < 0) {
            throw new IllegalArgumentException("Course ID must be greater od equal to 0");
        }

        if (name.length() <= 0) {
            throw new IllegalArgumentException("Your course name length must be greater than one character");
        }

        if(students.isEmpty()){
            throw new IllegalArgumentException("Userlist have to contains students!");
        }

        if (id > 0 && name.length() > 0) {
            new Course(id, name, students);
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
        } else {
            students.add(user);
        }
    }
}

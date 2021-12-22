import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final Long id;
    private final String login;
    private final String password;
    private final String name;
    private final String surname;
    private final String PID;
    private final UserType type;
    private final List<Long> courseIds;
    private final Map<Long, List<Grade>> courseIdToGrades;


    public User(Long id, String login, String password, String name, String surname, String PID, UserType type) {

        if (id < 0) {
            throw new IllegalArgumentException("You can't create user with id lower than zero!");
        }

        if (login.length() <= 0 || password.length() <= 0 || name.length() <= 0 || surname.length() <= 0 || PID.length() <= 0) {
            throw new IllegalArgumentException("Check that your's login, passowrd, name, surename, PID length is lower or eqal to 0!");
        }


        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.PID = PID;
        this.type = type;
        courseIds = new ArrayList<>();
        courseIdToGrades = new HashMap<>();

    }


    public UserType getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public List<Grade> gradesByCourseId(Long courseId) {
        return courseIdToGrades.get(courseId);
    }

    public List<Long> getCourses() {
        return courseIds;
    }

    void subscribeToCourse(Course course) {
        courseIds.add(course.getId());
        courseIdToGrades.put(course.getId(), new ArrayList<>());
    }

}

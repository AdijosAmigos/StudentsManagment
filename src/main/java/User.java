import java.util.*;

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

    void addGrade(Long courseId, Grade grade) {
        List<Grade> gradeList = courseIdToGrades.get(courseId);
        gradeList.add(grade);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(PID, user.PID) && type == user.type && Objects.equals(courseIds, user.courseIds) && Objects.equals(courseIdToGrades, user.courseIdToGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, surname, PID, type, courseIds, courseIdToGrades);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", PID='" + PID + '\'' +
                ", type=" + type +
                ", courseIds=" + courseIds +
                ", courseIdToGrades=" + courseIdToGrades +
                '}';
    }
}

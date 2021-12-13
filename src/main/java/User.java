import java.util.ArrayList;
import java.util.List;

public class User {

    private final Integer id;
    private final String login;
    private final String password;
    private final String name;
    private final String surname;
    private final String PID;
    private final UserType type;
    private final List<Course> courses;


    public User(Integer id, String login, String password, String name, String surname, String PID, UserType type) {

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
        courses = new ArrayList<>();
    }


    public UserType getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    void subscribeToCourse(Course course){
        courses.add(course); //przetestowac ta metode
    }

}

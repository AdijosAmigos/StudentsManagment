public class User {

    private final Integer id;
    private final String login;
    private final String password;
    private final String name;
    private final String surname;
    private final String PID;
    private final UserType type;


    public User(Integer id, String login, String password, String name, String surname, String PID, UserType type) {
        this.id = id;
        this.login = login;
        this.password =password;
        this.name = name;
        this.surname = surname;
        this.PID = PID;
        this.type = type;
    }

    public UserType getType() {
        return type;
    }
}

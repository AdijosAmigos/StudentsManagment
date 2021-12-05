public class User {

    private final Integer id;
    private final String login;
    private final String password;
    private final String name;
    private final String surname;
    private final String PID;
    private final UserType type;


    public User(Integer id, String login, String password, String name, String surname, String PID, UserType type) {

        if (id < 0) {
            throw new IllegalArgumentException("You can't create user with id lower than zero!");
        }

        if (login.length() <= 0 || password.length() <=0 || name.length() <=0 || surname.length() <=0 || PID.length() <=0) {
            throw new IllegalArgumentException("Check that your's login, passowrd, name, surename, PID length is lower or eqal to 0!");
        }

        if(getType() == null){
            throw new IllegalArgumentException("User type is null!");
        }

        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.PID = PID;
        this.type = type;
    }

    public UserType getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

}

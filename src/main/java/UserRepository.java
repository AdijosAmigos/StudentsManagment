import java.util.List;

public interface UserRepository {
    User getById(int id);
    User update(User user);
    User save(User user);
    User delete(User user);
    List<User> findAll();
}

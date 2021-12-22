import java.util.List;

public interface UserRepository {
    User getById(Long id);

    User save(User user);

    User delete(User user);

    List<User> findAll();
}

import java.util.List;

public interface UserRepository {
    User getById(int id);

//    User update(User user); -> nie potrzebna robi to samo co save()

    User save(User user);

    User delete(User user);

    List<User> findAll();
}

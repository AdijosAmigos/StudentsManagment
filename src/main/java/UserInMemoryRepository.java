import java.util.HashMap;
import java.util.List;

public class UserInMemoryRepository implements UserRepository {
    private final HashMap<Integer, User> idToUser;

    public UserInMemoryRepository(HashMap<Integer, User> idToUser) {
        this.idToUser = idToUser;
    }

    public HashMap<Integer, User> getIdToUser() {
        return idToUser;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}

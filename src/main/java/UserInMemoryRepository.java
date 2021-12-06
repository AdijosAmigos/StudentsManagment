import java.util.ArrayList;
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
        return idToUser.get(id);
    }

    @Override
    public User update(User user) {
      return user;
    }

    @Override
    public User save(User user) {
        return idToUser.put(user.getId(), user);
    }

    @Override
    public User delete(User user) {
        return idToUser.remove(user.getId());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(idToUser.values());
    }
}

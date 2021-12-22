import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInMemoryRepository implements UserRepository {
    private final Map<Long, User> idToUser;

    public UserInMemoryRepository(Map<Long, User> idToUser) {
        this.idToUser = idToUser;
    }

    public Map<Long, User> getIdToUser() {
        return idToUser;
    }

    @Override
    public User getById(Long id) {
        return idToUser.get(id);
    }


    @Override
    public User save(User user) {
        idToUser.put(user.getId(), user);
        return idToUser.get(user.getId());
    }


    @Override
    public User delete(User user) {
        return idToUser.remove(user.getId());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(idToUser.values());
    }
}

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInMemoryRepositoryTest {

    @Test
    void should_save_user() {
        //given
        UserRepository userInMemoryRepository = new UserInMemoryRepository(new HashMap<Long, User>());
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        //when
        User result = userInMemoryRepository.save(user);
        //then
        Assertions.assertThat(result).isEqualTo(user);

    }

    @Test
    void should_return_user_by_id() {
        //given
        HashMap<Long, User> map = new HashMap<>();
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map);
        userInMemoryRepository.save(user);
        //when
        User result = userInMemoryRepository.getById(user.getId());
        //then
        Assertions.assertThat(result).isEqualTo(user);
        Assertions.assertThat(map.containsKey(user.getId())).isTrue();
    }

    @Test
    void should_delete_user() {
        //given
        HashMap<Long, User> map = new HashMap<>();
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map);
        userInMemoryRepository.save(user);
        //when
        User result = userInMemoryRepository.delete(user);
        //then
        Assertions.assertThat(result).isEqualTo(user);
    }


    @Test
    void should_finall_users() {
        //given
        HashMap<Long, User> map = new HashMap<>();
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map);
        userInMemoryRepository.save(user);
        //when
        List<User> userList = userInMemoryRepository.findAll();
        //then
        Assertions.assertThat(userList).contains(user);
    }

}
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInMemoryRepositoryTest {

//    should_save_user -> blad to poprawy "expecting <null>"

    @Test
    void should_save_user() {
        //given
        User user = new User(1, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(new HashMap<Integer, User>());
        //when
        User result = userInMemoryRepository.save(user);
        //then
        Assertions.assertThat(result).isEqualTo(user);
        boolean areEquals = user.equals(result);
        Assertions.assertThat(areEquals).isTrue();
    }

    @Test
    void should_return_user_by_id() {
        //given
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        User user = new User(1, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
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
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        User user = new User(1, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map);
        userInMemoryRepository.save(user);
        //when
        User result = userInMemoryRepository.delete(user);
        //then
        Assertions.assertThat(map.isEmpty()).isTrue();
    }

//    czy napewno tutaj sprawdzam czy znalazlo uzytkownika w liscie?
//    tak naprawde sprawdzam czy rozmiar listy > 0 czyli czy user znajduje sie w liscie czyli dzostal tam zapisany
//    analogicznie w CourseInMemoryRepository

    @Test
    void should_finall_users() {
        //given
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        User user = new User(1, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map);
        userInMemoryRepository.save(user);
        //when
        List<User> userList = userInMemoryRepository.findAll();
        //then
        Assertions.assertThat(userList.size()).isGreaterThan(0);
    }

    // TODO: should_update_user
    @Test
    void should_update_user() {

    }

}
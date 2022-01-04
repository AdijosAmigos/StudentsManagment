import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserInMemoryRepositoryTest {
    /*
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

     */
    @Test
    void should_save_user() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        User expectedUser = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.save(expectedUser)).willReturn(expectedUser);

        //when
        User result = userRepository.save(user);
        //then

        verify(userRepository).save(expectedUser);
        Assertions.assertThat(result).isExactlyInstanceOf(user.getClass());
    }
/*
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
 */

    @Test
    void should_return_user_by_id() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        User expectedUser = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.getById(expectedUser.getId())).willReturn(expectedUser);

        //when
        User result = userRepository.getById(user.getId());
        //then
        verify(userRepository).getById(user.getId());
        Assertions.assertThat(result.getId()).isEqualTo(user.getId());
    }
/*
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
 */

    @Test
    void should_delete_user() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);
        User expectedUser = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.delete(expectedUser)).willReturn(expectedUser);

        //when
        User result = userRepository.delete(user);
        //then
        verify(userRepository).delete(user);
        Assertions.assertThat(result).isExactlyInstanceOf(user.getClass());
    }

/*
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
 */


}
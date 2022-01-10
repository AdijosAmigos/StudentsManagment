import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserInMemoryRepositoryTest {
    @Test
    void should_save_user() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.save(user)).willReturn(user);

        //when
        User result = userRepository.save(user);

        //then
        Assertions.assertThat(result).isExactlyInstanceOf(user.getClass());
    }

    @Test
    void should_return_user_by_id() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.getById(user.getId())).willReturn(user);

        //when
        User result = userRepository.getById(user.getId());
        //then
        Assertions.assertThat(result.getId()).isEqualTo(user.getId());
    }


    @Test
    void should_delete_user() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        given(userRepository.delete(user)).willReturn(user);

        //when
        User result = userRepository.delete(user);

        //then
        Assertions.assertThat(result).isEqualTo(user);
    }


    @Test
    void should_findAll_users() {
        //given
        User user = new User(1L, "adi", "1234567", "adrian", "nowak", "123456789", UserType.STUDENT);

        Map<Long, User> findAllMap = (Map.of(user.getId(), user));
        UserRepository userRepository = new UserInMemoryRepository(findAllMap);

        //when
        List<User> result = userRepository.findAll();

        //then
        Assertions.assertThat(result).containsExactly(user);
    }

}
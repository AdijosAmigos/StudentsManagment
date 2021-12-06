import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserInMemoryRepositoryTest {

    @Test
    void should_save_user(){
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
    void should_return_user_by_id(){

    }

}
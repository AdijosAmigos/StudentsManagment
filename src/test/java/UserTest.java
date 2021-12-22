import com.sun.nio.sctp.IllegalReceiveException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void should_throw_execption_when_id_lower_than_zero() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new User(-1L, null, null, null, null, null, UserType.STUDENT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can't create user with id lower than zero!");
    }

    @Test
    void should_throw_excepction_when_login_password_name_surename_PID_length_lower_or_equal_zero() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new User(1L, "", "", "", "", "", UserType.STUDENT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Check that your's login, passowrd, name, surename, PID length is lower or eqal to 0!");
    }

    @Test
    void should_throw_exception_when_userType_is_null() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new User(1L, "adi", "123", "adrian", "nowak", "123456789", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User type is null!");
    }

    @Test
    void should_subscribe_to_course() {
        //given
        Course course = new Course(1L, "math");
        User user = new User(1L, "admin", "123435", "adam", "nowak", "123456789", UserType.STUDENT);
        //when
        user.subscribeToCourse(course);
        //then
        Assertions.assertThat(user.getCourses().isEmpty()).isFalse();
        Assertions.assertThat(user.gradesByCourseId(course.getId())).isEmpty();
        //TODO: sprawdzić że lista ocen jest pusta pod kluczem courseId -> DONE
    }


}
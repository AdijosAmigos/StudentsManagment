import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

//    czy tak to ma działać?

    @Test
    void should_throw_execption_when_id_lower_than_zero() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Course(-1, "math", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Course ID must be greater od equal to 0");
    }

    @Test
    void should_throw_exception_when_course_name_length_lower_or_equal_than_zero() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Course(1, "", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your course name length must be greater than one character");
    }


//    blad StackOverlowError zniknal
//    blad "usertype is null"?

    @Test
    void should_create_new_course_when_correct_parameters() {
        //given
        User user = new User(1, "ad", "12345", "adrian", "nowak", "123456789", UserType.STUDENT);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        //when
        Course course = new Course(1, "math", userList);
        //then
        Assertions.assertThat(course).isInstanceOf(Course.class); // -> tworze course i skoro się utworzyl to musi byc typu Course

    }

    @Test
    void should_create_course_when_correct_parameters() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Course(1, "math", new ArrayList<>()))
                .isInstanceOf(Object.class);
    }

}


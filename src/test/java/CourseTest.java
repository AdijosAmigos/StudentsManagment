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

//    czy ten test ma sens? na poczatku może być nikt nie zapisany do przedmiotu
//    studenci sami moga sie zapisywac na przedmiot w pozniejszym czasie
//    czy nie lepiej byloby sprawdzic czy lista zawiera obiekty pożądanego typu?
    @Test
    void should_throw_exception_when_on_userlist_is_empty(){
        //given
        //when
        //then
        Assertions.assertThatThrownBy(()-> new Course(1, "math", new ArrayList<User>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Userlist have to contains students!");
    }

}
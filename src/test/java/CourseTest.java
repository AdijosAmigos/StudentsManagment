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
        //then
        Assertions.assertThatThrownBy(() -> new Course(-1, "math"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Course ID must be greater od equal to 0");
    }

    @Test
    void should_throw_exception_when_course_name_length_lower_or_equal_than_zero() {
        //then
        Assertions.assertThatThrownBy(() -> new Course(1, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your course name length must be greater than one character");
    }


    @Test
    void should_create_new_course_when_correct_parameters() {
        //when
        Course course = new Course(1, "math");
        //then
        Assertions.assertThat(course.getId()).isEqualTo(Integer.valueOf(1)); // -> tworze course i skoro się utworzyl to musi byc typu Course
        Assertions.assertThat(course.getName()).isEqualTo("math");

    }

//    TODO: test do addStudent musi tworzyc kurs //when add student //then course.getstudents nie moze byc pusta i musi zawierac studetna

}


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {


    @Test
    void should_throw_execption_when_id_lower_than_zero() {
        //then
        Assertions.assertThatThrownBy(() -> new Course(-1L, "math"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Course ID must be greater od equal to 0");
    }

    @Test
    void should_throw_exception_when_course_name_length_lower_or_equal_than_zero() {
        //then
        Assertions.assertThatThrownBy(() -> new Course(1L, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your course name length must be greater than one character");
    }


    @Test
    void should_create_new_course_when_correct_parameters() {
        //when
        Course course = new Course(1L, "math");
        //then
        Assertions.assertThat(course.getId()).isEqualTo(Integer.valueOf(1));
        Assertions.assertThat(course.getName()).isEqualTo("math");

    }

//    TODO: test do addStudent musi tworzyc kurs //when add student //then course.getstudents nie moze byc pusta i musi zawierac studetna

    @Test
    void should_add_student_to_course() {
        //given
        User user = new User(1L, "admin", "12345", "adam", "nowak", "1234567", UserType.STUDENT);
        Course course = new Course(1L, "math");
        //when
        course.addStudent(user);
        //then
        Assertions.assertThat(course.getStudents()).isNotEmpty().contains(user);
    }
}


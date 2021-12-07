import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Test
    void should_sign_up_student_to_course() {
        //given
        ArrayList<User> studensList = new ArrayList<>();
        HashMap<Integer, Course> idToCourse = new HashMap<>();
        User user = new User(1, "ad", "12345", "adrian", "nowak", "123456789", UserType.STUDENT);
        Course course = new Course(1, "math", studensList);
        CourseRepository courseInMemoryReposiotory = new CourseInMemoryRepository(idToCourse);
        course.addStudent(user);
        //when
        Course result = courseInMemoryReposiotory.update(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
    }

}
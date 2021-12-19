import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Test
    void should_sign_up_student_to_course() {
        //given
        Course course = new Course(1, "math");
        User user = new User(1, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        HashMap<Integer, User> map1 = new HashMap<Integer, User>();
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map1);
        courseInMemoryRepository.save(course);
        userInMemoryRepository.save(user);
        CourseService courseService = new CourseService(courseInMemoryRepository, userInMemoryRepository);
        //when
        courseService.signUpStudentToCourse(user.getId(), course.getId());
        //then
        Assertions.assertThat(userInMemoryRepository.findAll()).isNotEmpty();
        Assertions.assertThat(courseInMemoryRepository.findAll()).isNotEmpty();

    }

}
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Test
    void should_sign_up_student_to_course() {
        //given
        Course course = new Course(1L, "math");
        User user = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        HashMap<Long, Course> map = new HashMap<>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        HashMap<Long, User> map1 = new HashMap<>();
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map1);
        courseInMemoryRepository.save(course);
        userInMemoryRepository.save(user);
        CourseService courseService = new CourseService(courseInMemoryRepository, userInMemoryRepository);
        //when
        courseService.signUpStudentToCourse(user.getId(), course.getId());
        //then
        User updatedUser = userInMemoryRepository.getById(user.getId());
        Course updatedCourse = courseInMemoryRepository.getById(course.getId());
        Assertions.assertThat(updatedUser.getCourses()).contains(course.getId());
        Assertions.assertThat(updatedCourse.getStudents()).contains(user);
        Assertions.assertThat(updatedUser.gradesByCourseId(course.getId())).isEmpty();
    }

}
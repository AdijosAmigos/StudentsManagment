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

class CourseServiceTest {

    /*
    @Test
    void should_sign_up_student_to_course() {

        //given
        Course course = new Course(1L, "math");
        User user = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        Map<Long, Course> map = new HashMap<>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        Map<Long, User> map1 = new HashMap<>();
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
        Assertions.assertThat(updatedCourse.getStudents()).contains(user.getId());
        Assertions.assertThat(updatedUser.gradesByCourseId(course.getId())).isEmpty();
    }
    */

    /*
    @Test
    void should_assign_grade_to_student_course() {
        //given
        Course course = new Course(1L, "math");
        User user = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        Grade grade = new Grade(GradeValue.ONE);
        Map<Long, Course> map = new HashMap<>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        Map<Long, User> map1 = new HashMap<>();
        UserRepository userInMemoryRepository = new UserInMemoryRepository(map1);
        courseInMemoryRepository.save(course);
        userInMemoryRepository.save(user);
        CourseService courseService = new CourseService(courseInMemoryRepository, userInMemoryRepository);
        //when
        courseService.assignGradeToStudent(user.getId(), course.getId(), grade);
        //then
        Assertions.assertThat(userInMemoryRepository.getById(user.getId()).gradesByCourseId(course.getId())).containsExactly(grade);

    }
    */

    // blad nie zgadzaja sie parametry usera
    @Test
    void should_assign_grade_to_student_course() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");
        Grade grade = new Grade(GradeValue.FIVE);
        Grade expectedGrade = new Grade(GradeValue.FIVE);
        User user = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        User expectedUser = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);

        expectedUser.subscribeToCourse(expectedCourse);
        expectedCourse.addStudent(expectedUser);

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        given(courseRepository.save(expectedCourse)).willReturn(expectedCourse);
        given(userRepository.save(expectedUser)).willReturn(expectedUser);

        CourseService courseService = new CourseService(courseRepository, userRepository);

        given(courseRepository.getById(course.getId())).willReturn(course);
        given(userRepository.getById(user.getId())).willReturn(user);

        User result = courseService.signUpStudentToCourse(user.getId(), course.getId());

        //when
        courseService.assignGradeToStudent(expectedUser.getId(), expectedCourse.getId(), expectedGrade);

        //then
        verify(userRepository).save(expectedUser);
        verify(courseRepository).save(expectedCourse);
        Assertions.assertThat(result.gradesByCourseId(course.getId())).containsExactly(grade);

    }

    @Test
    void should_sign_up_student_to_course_with_mocks() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");
        User user = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        User expectedUser = new User(1L, "adam", "12345", "adam", "nowak", "123456789", UserType.STUDENT);
        expectedUser.subscribeToCourse(course);
        expectedCourse.addStudent(expectedUser);

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        given(userRepository.save(expectedUser)).willReturn(expectedUser);
        given(courseRepository.save(expectedCourse)).willReturn(expectedCourse);


        CourseService courseService = new CourseService(courseRepository, userRepository);

        given(userRepository.getById(user.getId())).willReturn(user);
        given(courseRepository.getById(course.getId())).willReturn(course);

        //when
        User result = courseService.signUpStudentToCourse(user.getId(), course.getId());
        //then

        verify(userRepository).save(expectedUser);
        verify(courseRepository).save(expectedCourse);
        Assertions.assertThat(result.getCourses()).containsExactly(course.getId());

        //TODO: przepisac wszystkie testy do mokito courseService, course in memory repository, userinmemoryreposiotry

    }

}
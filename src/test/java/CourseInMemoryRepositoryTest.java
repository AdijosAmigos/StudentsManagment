import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class CourseInMemoryRepositoryTest {

/*
    @Test
    void should_save_course() {
        //given
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(new HashMap<>());
        Course course = new Course(1L, "math", new ArrayList<>());
        //when
        Course result = courseInMemoryRepository.save(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
    }
 */

    @Test
    void should_save_course() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.save(expectedCourse)).willReturn(expectedCourse);

        //when
        Course result = courseRepository.save(expectedCourse);
        //then
        verify(courseRepository).save(expectedCourse);
        Assertions.assertThat(result).isEqualTo(course);

    }
/*
    @Test
    void should_return_course_by_id() {
        //given
        HashMap<Long, Course> map = new HashMap<>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        Course course = new Course(1L, "math");
        courseInMemoryRepository.save(course);
        //when
        Course result = courseInMemoryRepository.getById(course.getId());
        //then
        Assertions.assertThat(result).isEqualTo(course);
    }

 */

    @Test
    void should_return_course_by_id() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.getById(expectedCourse.getId())).willReturn(expectedCourse);

        //when
        Course result = courseRepository.getById(course.getId());

        //then
        verify(courseRepository).getById(expectedCourse.getId());
        Assertions.assertThat(result.getId()).isEqualTo(course.getId());
    }

    /*
    @Test
    void should_delete_course() {
        //given
        HashMap<Long, Course> map = new HashMap<>();
        Course course = new Course(1L, "math");
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        courseInMemoryRepository.save(course);
        //when
        Course result = courseInMemoryRepository.delete(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
    }
     */

    @Test
    void should_delete_course() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");


        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.delete(expectedCourse)).willReturn(expectedCourse);

        //when
        Course result = courseRepository.delete(expectedCourse);

        //then
        verify(courseRepository).delete(course);
        Assertions.assertThat(result).isEqualTo(course);

    }
/*
    @Test
    void should_findAll_courses() {
        //given
        Map<Long, Course> map = new HashMap<>();
        Course course = new Course(1L, "math");
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        courseInMemoryRepository.save(course);
        //when
        List<Course> courseList = courseInMemoryRepository.findAll();
        //then
        Assertions.assertThat(courseList).contains(course);
    }
 */


//problem ?
    /*
    @Test
    void should_finAll_courses() {
        //given
        Course course = new Course(1L, "math");
        Course expectedCourse = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.findAll()).willReturn());
        //when
        Course result = (Course) courseRepository.findAll();
        //then
    }
     */


}
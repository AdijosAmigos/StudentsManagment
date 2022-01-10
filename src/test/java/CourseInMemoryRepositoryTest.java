import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class CourseInMemoryRepositoryTest {

    @Test
    void should_save_course() {
        //given
        Course course = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.save(course)).willReturn(course);

        //when
        Course result = courseRepository.save(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);

    }

    @Test
    void should_return_course_by_id() {
        //given
        Course course = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.getById(course.getId())).willReturn(course);

        //when
        Course result = courseRepository.getById(course.getId());

        //then
        Assertions.assertThat(result.getId()).isEqualTo(course.getId());
    }


    @Test
    void should_delete_course() {
        //given
        Course course = new Course(1L, "math");

        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        given(courseRepository.delete(course)).willReturn(course);

        //when
        Course result = courseRepository.delete(course);

        //then
        Assertions.assertThat(result).isEqualTo(course);

    }

    @Test
    void should_finAll_courses() {
        //given
        Course course = new Course(1L, "math");

        Map<Long, Course> findAllMap = Map.of(course.getId(), course);
        CourseRepository courseRepository = new CourseInMemoryRepository(findAllMap);

        //when
        List<Course> result = courseRepository.findAll();

        //then
        Assertions.assertThat(result).containsExactly(course);
    }


}
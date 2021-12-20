import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CourseInMemoryRepositoryTest {

//  TODO: should_save_course -> blad do poprawy

    @Test
    void should_save_course() {
        //given
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(new HashMap<Long, Course>());
        Course course = new Course(1L, "math", new ArrayList<>());
        //when
        Course result = courseInMemoryRepository.save(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
    }


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

    //TODO: zmienic typ na interfejs MAP oraz poprawić błędy w typach mapy "Long" zamiast Integer

}
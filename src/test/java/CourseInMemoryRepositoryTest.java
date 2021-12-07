import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseInMemoryRepositoryTest {

//    should_save_course -> blad do poprawy

    @Test
    void should_save_course() {
        //given
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(new HashMap<Integer, Course>());
        Course course = new Course(1, "math", new ArrayList<User>());
        //when
        Course result = courseInMemoryRepository.save(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
        boolean areEquals = course.equals(result);
        Assertions.assertThat(areEquals).isTrue();
    }


    @Test
    void should_return_course_by_id() {
        //given
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        Course course = new Course(1, "math", null);
        courseInMemoryRepository.save(course);
        //when
        Course result = courseInMemoryRepository.getById(course.getId());
        //then
        Assertions.assertThat(result).isEqualTo(course);
        Assertions.assertThat(map.containsKey(course.getId())).isTrue();
    }

    @Test
    void should_delete_course() {
        //given
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        Course course = new Course(1, "math", null);
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        courseInMemoryRepository.save(course);
        //when
        Course result = courseInMemoryRepository.delete(course);
        //then
        Assertions.assertThat(map.isEmpty()).isTrue();
    }

    @Test
    void should_findAll_courses() {
        //given
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        Course course = new Course(1, "math", null);
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        courseInMemoryRepository.save(course);
        //when
        List<Course> courseList = courseInMemoryRepository.findAll();
        //then
        Assertions.assertThat(courseList.size()).isGreaterThan(0);
    }

    //    TODO: should_update_course
    @Test
    void should_update_course() {

    }

}
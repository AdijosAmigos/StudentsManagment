import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CourseInMemoryRepositoryTest {

// StackOverflowError

    @Test
    void should_save_course(){
        //given
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(new HashMap<Integer, Course>());
        Course course = new Course(1, "math", new ArrayList<>());
        //when
        Course result = courseInMemoryRepository.save(course);
        //then
        Assertions.assertThat(result).isEqualTo(course);
        boolean areEquals = course.equals(result);
        Assertions.assertThat(areEquals).isTrue();
    }


// jest do dokonczenia
    @Test
    void should_return_course_by_id() {
        //given
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        ArrayList<User> courselist = new ArrayList<>();
        CourseRepository courseInMemoryRepository = new CourseInMemoryRepository(map);
        Course course = new Course(1,"math", courselist);
        //when
        //then
    }
}
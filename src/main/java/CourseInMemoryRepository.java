import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseInMemoryRepository implements CourseRepository {

    private final Map<Long, Course> idToCourse;

    public CourseInMemoryRepository(Map<Long, Course> idToCourse) {
        this.idToCourse = idToCourse;
    }

    @Override
    public Course getById(Long id) {
        return idToCourse.get(id);
    }


    @Override
    public Course save(Course course) {
        idToCourse.put(course.getId(), course);
        return idToCourse.get(course.getId());
    }

    @Override
    public Course delete(Course course) {
        return idToCourse.remove(course.getId());

    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<Course>(idToCourse.values());

    }
}

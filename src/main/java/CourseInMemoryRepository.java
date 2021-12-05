import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseInMemoryRepository implements CourseRepository {

    private final HashMap<Integer, Course> idToCourse;

    public CourseInMemoryRepository(HashMap<Integer, Course> idToCourse) {
        this.idToCourse = idToCourse;
    }

    @Override
    public Course getById(int id) {
        return idToCourse.get(id);
    }

    @Override
    public Course update(Course course) {
        return course.setName();
    }

    @Override
    public Course save(Course course) {
        return idToCourse.put(course.getId(), course);
    }

    @Override
    public Course delete(Course course) {
        idToCourse.remove(course.getId());
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> list = new ArrayList<Course>(idToCourse.values());
        return list;
    }
}

import java.util.List;

public interface CourseRepository {

    Course getById(Long id);

    Course save(Course course);

    Course delete(Course course);

    List<Course> findAll();

}

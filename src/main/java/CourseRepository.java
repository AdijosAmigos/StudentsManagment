import java.util.List;

public interface CourseRepository {
//    TODO: napisac analogicznie do UserRepository
//    TODO: courseInMemoryRepository analogicznie do user + testy
    Course getById(int id);
    Course update(Course course);
    Course save(Course course);
    Course delete(Course course);
    List<Course> findAll();

}

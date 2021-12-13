import java.util.List;

public interface CourseRepository {

    Course getById(int id);

//    Course update(Course course); -> nie potrzebna robi to samo co save()

    Course save(Course course);

    Course delete(Course course);

    List<Course> findAll();

}

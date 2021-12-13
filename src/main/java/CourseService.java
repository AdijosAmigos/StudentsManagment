import java.util.HashMap;
import java.util.Map;

public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    void signUpStudentToCourse(int userId, int courseId) {


        User user = userRepository.getById(userId);
        Course course = courseRepository.getById(courseId);

        course.addStudent(user);
        courseRepository.save(course);
        user.subscribeToCourse(course);
        userRepository.save(user);


    }

}

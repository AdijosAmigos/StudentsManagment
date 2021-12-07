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

        /*
        userrepo.getuser()
        courserepo.getcourse()
        courseRepoo.update()
         */

        User user = userRepository.getById(userId);
        Course course = courseRepository.getById(courseId);

        course.addStudent(user);
        courseRepository.update(course);


//        TODO: zaimplementowac metode update + testy do CourseService

    }

}

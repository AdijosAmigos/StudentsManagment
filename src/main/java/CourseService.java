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

        Map<User, Course> studentsToCourse = new HashMap<>();
        studentsToCourse.put(userRepository.getById(userId), courseRepository.getById(courseId));



//        TODO: zaimplementowac metode update + testy do CourseService

    }

}

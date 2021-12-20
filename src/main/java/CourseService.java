import java.util.HashMap;
import java.util.Map;

public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    void signUpStudentToCourse(int userId, Long courseId) {

        User user = userRepository.getById(userId);
        Course course = courseRepository.getById(courseId);

        course.addStudent(user);
        courseRepository.save(course);
        user.subscribeToCourse(course);
        userRepository.save(user);

    }

    //TODO: napisać metode w courseService rezultat uczen bedzie miał ocene z danego kursu

    void assignGradeToStudent(int userId, Long courseId, Grade grade){

    }

}

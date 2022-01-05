import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    User signUpStudentToCourse(Long userId, Long courseId) {

        User user = userRepository.getById(userId);
        Course course = courseRepository.getById(courseId);

        course.addStudent(user);
        courseRepository.save(course);
        user.subscribeToCourse(course);
        return userRepository.save(user);

    }


    void assignGradeToStudent(Long userId, Long courseId, Grade grade) {

        User user = userRepository.getById(userId);
        if(user.getCourses().isEmpty()){
            throw new IllegalArgumentException("Student is not signup in the course");
        }

        user.addGrade(courseId, grade);

        userRepository.save(user);

    }

}

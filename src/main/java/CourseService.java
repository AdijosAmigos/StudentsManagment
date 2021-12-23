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

    //TODO: napisać metode w courseService rezultat uczen bedzie miał ocene z danego kursu ->DONE?

    void assignGradeToStudent(Long userId, Long courseId, Grade grade) {

        User user = userRepository.getById(userId);
        signUpStudentToCourse(userId, courseId); // -> nie zapisuje go na kurs tylko sprawdzam czy jest juz zapisany i jezeli nie jest to wyrzacam wyjkatek

        user.addGrade(courseId, grade);

        userRepository.save(user);

    }

}

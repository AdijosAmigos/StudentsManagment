public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    void signUpStudentToCourse(int userId, int courseId){

        /*
        userrepo.getuser()
        courserepo.getcourse()
        courseRepoo.update()
         */

        Course course;
        User user;

//        TODO: zaimplementowac metode update + testy do CourseService

    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private final Long id;
    private final String name;
    private final List<Long> studentIds;
//TODO: linia 7 i wszystko co związane z lnia 7 przerobić z User na UserIds analogicznie jak z Long w courses -> do zbierania

    public Course (Long id, String name){
        this(id, name, new ArrayList<>());
    }


    public Course(Long id, String name, List<Long> studentIds) {

        if (id < 0) {
            throw new IllegalArgumentException("Course ID must be greater od equal to 0");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Your course name length must be greater than one character");
        }

        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getStudents() {
        return studentIds;
    }

    void addStudent(User user) {
        if (!(user.getType() == UserType.STUDENT)) {
            throw new IllegalArgumentException();
        }
        studentIds.add(user.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(studentIds, course.studentIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, studentIds);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + studentIds +
                '}';
    }
}

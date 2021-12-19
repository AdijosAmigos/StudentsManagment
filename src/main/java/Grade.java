public class Grade {
    private final String grade;
    private final String description;


    public Grade(String grade) {
        this(grade, new String());
    }

    public Grade(String grade, String description) {

        if(grade == null || grade.isBlank()){
            throw new IllegalArgumentException("Grade can not be null or blank");
        }

        this.grade = grade;
        this.description = description;
    }

    public String getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }
}

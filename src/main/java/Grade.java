public class Grade {
    private final GradeValue gradeValue;
    private final String description;


    public Grade(GradeValue gradeValue) {
        this(gradeValue, "");
    }

    public Grade(GradeValue gradeValue, String description) {

        if(gradeValue == null){
            throw new IllegalArgumentException("Grade can not be null");
        }

        this.gradeValue = gradeValue;
        this.description = description;
    }

    public GradeValue getGrade() {
        return gradeValue;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeValue=" + gradeValue +
                ", description='" + description + '\'' +
                '}';
    }
}

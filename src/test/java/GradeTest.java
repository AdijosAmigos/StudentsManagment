import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GradeTest {

    @Test
    void should_create_grade_when_correct_parameters() {
        //then
        Assertions.assertThatThrownBy(() -> new Grade("", "math test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Grade can not be null or blank");
    }


}
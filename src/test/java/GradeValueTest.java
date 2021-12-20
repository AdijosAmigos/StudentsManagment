
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class GradeValueTest {

    @Test
    void should_grades_have_correct_values(){
        Assertions.assertThat(GradeValue.ONE.getValue()).isEqualTo(1.0f);
        //TODO: sprawdzić analogicznie kolejne oceny
    }

}
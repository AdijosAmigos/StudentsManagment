
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class GradeValueTest {

    @Test
    void should_grades_have_correct_values(){
        Assertions.assertThat(GradeValue.ONE.getValue()).isEqualTo(1.0f);
        Assertions.assertThat(GradeValue.TWO.getValue()).isEqualTo(2.0f);
        Assertions.assertThat(GradeValue.THREE.getValue()).isEqualTo(3.0f);
        Assertions.assertThat(GradeValue.THREE_PLUS.getValue()).isEqualTo(3.5f);
        Assertions.assertThat(GradeValue.FOUR.getValue()).isEqualTo(4.0f);
        Assertions.assertThat(GradeValue.FOUR_PLUS.getValue()).isEqualTo(4.5f);
        Assertions.assertThat(GradeValue.FIVE.getValue()).isEqualTo(5.0f);
        //TODO: sprawdzić analogicznie kolejne oceny -> DONE
    }

}
package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private final Computer computer = new Computer();
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        computer.setRandom3Numbers();
        numbers = computer.getNumbers();
    }

    @Test
    @DisplayName("숫자_1부터_9까지_서로다른_3자리_여부_테스트")
    void numbersTest() {
        assertThat(numbers)
                .doesNotHaveDuplicates()
                .hasSize(3)
                .allSatisfy(v -> assertThat(v).isBetween(1, 9));
    }

    @Test
    @DisplayName("숫자_reset_테스트")
    void numbersResetTest() {
        computer.resetNumbers();
        numbers = computer.getNumbers();
        assertThat(numbers).isEmpty();
    }

}

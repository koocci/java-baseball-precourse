package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    private final Player player = new Player();
    private List<Integer> numbers;

    @ParameterizedTest
    @ValueSource(strings = {"625", "125", "568", "932", "718"})
    @DisplayName("숫자_reset_테스트")
    void numbersResetTest(String number) {
        setPlayerNumbers(number);
        player.resetNumbers();
        numbers = player.getNumbers();
        assertThat(numbers).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "567", "819", "752"})
    @DisplayName("숫자_1부터_9까지_서로다른_3자리_입력_정상_테스트")
    void numbersTest1(String number) {
        setPlayerNumbers(number);
        assertThat(numbers)
                .doesNotHaveDuplicates()
                .hasSize(3)
                .allSatisfy(v -> assertThat(v).isBetween(1, 9));
    }

    @ParameterizedTest
    @ValueSource(strings = {"adg", "12g", "aaa", "$#^", "yn5", "@ㄷ1"})
    @DisplayName("숫자가_아닌_입력_테스트")
    void numbersTest2(String number) {
        numberExceptionSynario(number, "The input value must be integer except \"0\".");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "1"})
    @DisplayName("세자리가_아닌_입력_테스트")
    void numbersTest3(String number) {
        numberExceptionSynario(number, "The input numbers must be 3 digits.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"133", "111", "223"})
    @DisplayName("중복_입력_테스트")
    void numbersTest4(String number) {
        numberExceptionSynario(number, "The input numbers must be different numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"120", "037", "000"})
    @DisplayName("0이_포함된_입력_테스트")
    void numbersTest5(String number) {
        numberExceptionSynario(number, "The input value must be integer except \"0\".");
    }

    private void numberExceptionSynario(String number, String errMsg) {
        assertThatThrownBy(() -> {
            setPlayerNumbers(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errMsg);
    }

    private void setPlayerNumbers(final String input) {
        setInputStream(input);
        player.setInputNumbers();
        numbers = player.getNumbers();
    }

    private void setInputStream(final String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
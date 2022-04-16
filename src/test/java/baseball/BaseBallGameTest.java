package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest extends NsTest {
    private final BaseBallGame baseBallGame = new BaseBallGame();

    @Override
    public void runMain() {
        baseBallGame.start();
    }

    @Test
    @DisplayName("재시작_종료_입력_오류_테스트")
    void endOrRestartTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("The input value must be \"1\" or \"2\"");
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("스트라이크_갯수_테스트")
    void strikeTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123",
                            "512", "163", "347",
                            "568", "517", "167",
                            "567", "2");
                    assertThat(output()).contains("낫싱",
                            "1스트라이크", "1스트라이크", "1스트라이크",
                            "2스트라이크", "2스트라이크", "2스트라이크",
                            "3스트라이크");
                },
                5, 6, 7
        );
    }

    @Test
    @DisplayName("볼_갯수_테스트")
    void ballTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456",
                            "451", "452", "345",
                            "412", "431", "314",
                            "312",
                            "123", "2");
                    assertThat(output()).contains("낫싱",
                            "1볼", "1볼", "1볼",
                            "2볼", "2볼", "2볼",
                            "3볼",
                            "3스트라이크");
                },
                1, 2, 3
        );
    }

    @Test
    @DisplayName("스트라이크_볼_혼합_테스트")
    void strikeAndBallTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("134", "421", "253",
                            "132", "321", "213",
                            "312",
                            "123", "2");
                    assertThat(output()).contains(
                            "1볼 1스트라이크", "1볼 1스트라이크", "1볼 1스트라이크",
                            "2볼 1스트라이크", "2볼 1스트라이크", "2볼 1스트라이크",
                            "3스트라이크");
                },
                1, 2, 3
        );
    }
}
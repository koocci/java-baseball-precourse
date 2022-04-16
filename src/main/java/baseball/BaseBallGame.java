package baseball;

import static baseball.configuration.Configuration.GAME_OVER;
import static baseball.configuration.Configuration.RESTART;
import static baseball.configuration.Configuration.STRIKE_OUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGame {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private Integer strike;
    private Integer ball;

    public BaseBallGame() {
        resetScore();
    }

    public void start() {
        computerSetUp();
        do {
            play();
        } while (!isWin());
        gameOver();
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void computerSetUp() {
        computer.resetNumbers();
        computer.setRandom3Numbers();
    }

    private void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        endOrRestart();
    }

    private void endOrRestart() {
        String playerInput = getGameOverTypeInput();
        if (!(RESTART.equals(playerInput) || GAME_OVER.equals(playerInput))) {
            throw new IllegalArgumentException("The input value must be \"1\" or \"2\"");
        }
        if (RESTART.equals(playerInput)) {
            restart();
        }
    }

    private String getGameOverTypeInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private void restart() {
        resetScore();
        start();
    }

    private void play() {
        resetScore();
        playerSetUp();
        List<Integer> playerNumbers = player.getNumbers();
        for (int i = 0; i < playerNumbers.size(); i++) {
            setPlayResult(playerNumbers.get(i), i);
        }
        getPlayHint();
    }

    private void playerSetUp() {
        player.resetNumbers();
        player.setInputNumbers();
    }

    private Boolean isStrike(Integer number, Integer index) {
        List<Integer> computerNumbers = computer.getNumbers();
        return number.equals(computerNumbers.get(index));
    }

    private Boolean isBall(Integer number, Integer index) {
        List<Integer> computerNumbers = computer.getNumbers();
        return computerNumbers.contains(number) && !isStrike(number, index);
    }

    private void setPlayResult(Integer number, Integer index) {
        if (isStrike(number, index)) {
            strike++;
        }
        if (isBall(number, index)) {
            ball++;
        }
    }

    private Boolean isWin() {
        return strike == STRIKE_OUT;
    }

    private void setNothingHint(StringBuffer sb) {
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
    }

    private void setBallHint(StringBuffer sb) {
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
    }

    private void setStrikeHint(StringBuffer sb) {
        if (ball > 0 && strike > 0) {
            sb.append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
    }

    private void getPlayHint() {
        StringBuffer sb = new StringBuffer();
        setNothingHint(sb);
        setBallHint(sb);
        setStrikeHint(sb);
        System.out.println(sb);
    }
}

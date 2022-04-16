package baseball;

import static baseball.configuration.Configuration.MAX_NUMBERS_CNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers = new ArrayList<>();

    protected Player() {
    }

    public void setInputNumbers() {
        String[] splitNumberStr = getPlayerInput().split("");
        for (String s : splitNumberStr) {
            validate1DigitNumber(s);
            Integer newNumber = Integer.parseInt(s);
            validateUnique(newNumber);
            numbers.add(newNumber);
        }
        validateCount();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void resetNumbers() {
        numbers.clear();
    }

    private String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private void validate1DigitNumber(final String newNumberString) {
        if (!newNumberString.matches("[1-9]")) {
            throw new IllegalArgumentException("The input value must be integer except \"0\".");
        }
    }

    private void validateUnique(final Integer newNumber) {
        if (numbers.contains(newNumber)) {
            throw new IllegalArgumentException("The input numbers must be different numbers.");
        }
    }

    private void validateCount() {
        if (numbers.size() != MAX_NUMBERS_CNT) {
            throw new IllegalArgumentException("The input numbers must be 3 digits.");
        }
    }
}

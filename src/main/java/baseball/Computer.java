package baseball;

import static baseball.configuration.Configuration.MAX_NUMBERS_CNT;
import static baseball.configuration.Configuration.UNDER_BOUND_NUMBER;
import static baseball.configuration.Configuration.UPPER_BOUND_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    protected Computer() {
    }

    public void setRandom3Numbers() {
        while (numbers.size() < MAX_NUMBERS_CNT) {
            addNewNumber();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void resetNumbers() {
        numbers.clear();
    }

    private void addNewNumber() {
        int newNumber = Randoms.pickNumberInRange(UNDER_BOUND_NUMBER, UPPER_BOUND_NUMBER);
        if (isUnique(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private Boolean isUnique(final Integer newNumber) {
        return !numbers.contains(newNumber);
    }
}

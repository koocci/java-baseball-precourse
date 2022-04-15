package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    protected Computer() {
    }

    public void setRandom3Numbers() {
        while (numbers.size() < 3) {
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
        int newNumber = Randoms.pickNumberInRange(1, 9);
        if (isUnique(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private Boolean isUnique(final Integer newNumber) {
        return !numbers.contains(newNumber);
    }
}

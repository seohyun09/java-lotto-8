package lotto;

import java.util.HashSet;
import java.util.Set;

public final class LottoNumberValidator {

    public static String[] validateNumOfWinningNumber(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호 개수가 6개가 아닙니다.");
        }
        return winningNumbers;
    }

    public static void validateUniqueWinningNumber(String[] winningNumbers) {
        int[] numbers = new int[winningNumbers.length];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(winningNumbers[i])) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }
            set.add(winningNumbers[i]);

            numbers[i] = validateWinningNumberRange(winningNumbers[i]);
        }
    }

    public static int validateWinningNumberRange(String winningNumber) {
        if (!winningNumber.matches("^\\d+")) {
            throw new IllegalArgumentException("입력한 당첨 번호는 양의 정수이어야 합니다.");
        }

        int number = Integer.parseInt(winningNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("당첨 번호는 1과 45 사이의 숫자이어야 합니다.");
        }
        return number;
    }
}

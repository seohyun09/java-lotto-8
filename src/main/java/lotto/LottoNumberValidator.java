package lotto;

public final class LottoNumberValidator {

    public static void validateNumOfWinningNumber(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호 개수가 6개가 아닙니다.");
        }
    }

}

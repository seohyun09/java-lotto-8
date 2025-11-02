package lotto;

public final class PriceValidator {

    private PriceValidator() {
    }

    public static void validatePlusPrice(String inputPrice) {
        if (!inputPrice.matches("^\\d+")) {
            throw new IllegalArgumentException("구입금액은 양수만 입력 가능합니다.");
        }
    }

    public static void validatePriceUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로만 입력 가능합니다.");
        }
    }
}

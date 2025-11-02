package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();
        PriceValidator.validatePlusPrice(inputPrice);

        int price = Integer.parseInt(inputPrice);
        PriceValidator.validatePriceUnit(price);

        int buyCount = price / 1000;
        System.out.println(buyCount + "개를 구매했습니다.");


    }
}

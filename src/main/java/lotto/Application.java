package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();
        PriceValidator.validatePlusPrice(inputPrice);

        int price = Integer.parseInt(inputPrice);
        PriceValidator.validatePriceUnit(price);

        int buyCount = price / 1000;
        System.out.println(buyCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        LottoNumberValidator.validateNumOfWinningNumber(inputWinningNumbers);

        int[] numbers = new int[winningNumbers.length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            if (set.contains(winningNumbers[i])) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }
            set.add(winningNumbers[i]);

            if (!winningNumbers[i].matches("^\\d+")) {
                throw new IllegalArgumentException("입력한 당첨 번호는 양의 정수이어야 합니다.");
            }

            int number = Integer.parseInt(winningNumbers[i]);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1과 45 사이의 숫자이어야 합니다.");
            }
            numbers[i] = number;
        }



    }
}

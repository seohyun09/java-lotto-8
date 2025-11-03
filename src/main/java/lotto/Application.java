package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        String[] winningNumbers = LottoNumberValidator.validateNumOfWinningNumber(inputWinningNumbers);

        int[] numbers = LottoNumberValidator.validateUniqueWinningNumber(winningNumbers);

        System.out.println("보너스 번호를 입력하세요.");
        String inputBonus = Console.readLine();

        LottoNumberValidator.validateWinningNumberRange(inputBonus);
        int bonusNumber = LottoNumberValidator.validateUniqueBonusNumber(numbers, inputBonus);


    }
}

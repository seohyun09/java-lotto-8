package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoResultChecker {
    static Set<Integer> winningNumberSet = new HashSet<>();

    static public void numToSet(int[] numbers) {
        for (int i = 0; i < 6; i++) {
            winningNumberSet.add(numbers[i]);
        }
    }

    public static int LottoMatch(Lotto lotto, int[] numbers, int bonusNumber) {
        int cnt = 0;
        boolean bonusMatch = false;

        for (int lottoNumber : lotto.getNumbers()) {
            if (winningNumberSet.contains(lottoNumber)) {
                cnt++;
            }
            if (lottoNumber == bonusNumber) {
                bonusMatch = true;
            }
        }
        return LottoRank(cnt, bonusMatch);
    }

    private static int LottoRank(int cnt, boolean bonusMatch) {
        if (cnt == 6) {
            return 1;
        }
        if (cnt == 5 && bonusMatch) {
            return 2;
        }
        if (cnt == 5) {
            return 3;
        }
        if (cnt == 4) {
            return 4;
        }
        if (cnt == 3) {
            return 5;
        }
        return 0;
    }


}

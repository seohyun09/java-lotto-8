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

    public static void printLottoResult(int[] LottoRank) {
        System.out.println("3개 일치 (5,000원) - " + LottoRank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoRank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoRank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoRank[2] + "개");
        System.out.println("6개 일치 (2,000,000원) - " + LottoRank[1] + "개");
    }
}

/**
 * 3_9: 課題内容
 *
 * 本課題では、基本的なJavaの構造と、importについて理解を深めていきましょう。
 *
 * 問①〜問②まであります。
 * 全て回答し、課題にある画像と同じ表示になるようにしてください。
 *
 *
 */

package study;

// ① FruitsConstantsクラスとFruitsクラスをインポートして下さい
import constants.FruitsConstants;
import fruits.Fruits;

public class Study extends FruitsConstants {

    public static void main(String[] args) {

        /* ② Fruits.javaのprintFruitsメソッドを呼び出して下さい。
         *     また、「コンソール出力結果」の通りとなるように、
         *     printFruitsの引数にはFruitsConstantsから呼び出した値を設定してください。
         */
    	
    		Fruits.printFruits(FruitsConstants.FRUITS_LEMON_04, FruitsConstants.FRUITS_COUNT_20);
    		

    }
}

/* コンソール出力結果↓

食べ物はレモン
20個です

 */
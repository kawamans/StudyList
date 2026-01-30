package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 3_10 : 課題内容
 *
 * 本課題では、コレクションフレームワークのList系クラスとMap系クラスの基本的な記述を学びましょう。
 * 現場で必ず使用するものなので、ポイントをしっかり押さえておきましょう。
 *
 * 問①〜問③まであります。
 * 問②に関しては、コメントを記述してください。
 *
 */
public class Study {

    public static final String SHOP_SHOHIN_00 = "バナナ";
    public static final String SHOP_SHOHIN_01 = "牛乳";
    public static final String SHOP_SHOHIN_02 = "豚肉";
    public static final String SHOP_SHOHIN_03 = "コロッケ";

    public static void main(String args[]) {

        // ① 定数を全て使って、String型のListを記述してください。
        List<String> shohinList = new ArrayList<String>();

        // ② 以下の「shopMap.put(shohinList.get(0), 125);」はどのような処理をしているか、コメントを記述してください。
        /*
         * [ここへ記述]
         */
        HashMap<String, Integer> shopMap = new HashMap<String, Integer>();
        shopMap.put(shohinList.get(0), 125);
        shopMap.put(shohinList.get(1), 180);
        shopMap.put(shohinList.get(2), 350);
        shopMap.put(shohinList.get(3), 100);

        // ③ Wikiを参考に拡張for文を使って、「コンソール出力結果」と同じ表示になるよう記述してください。
        // 「shohinList」と「shopMap」が保持する値を上手く利用しましょう。

    }
}

/* コンソール出力結果↓

バナナ=125円になります
牛乳=180円になります
豚肉=350円になります
コロッケ=100円になります

 */
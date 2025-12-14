package sec4ex;

public class ProductUtil {
    // staticフィールド（検証に関連するルールや値）
    public static final int MIN_PRICE = 1;  // 価格下限の定数
    // staticメソッド（商品価格の検証）
    public static boolean isValidPrice(int price) {  // 価格が下限以上かをチェック
        boolean validResult = price >= MIN_PRICE;
        return validResult;
    }
}

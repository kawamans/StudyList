package study;

import java.util.Calendar;
import java.util.Date;

/**
 * 3_11: 課題内容
 * 本課題では、基本的な日付操作クラスの使い方を学びましょう。
 *
 * 問①から問③まであります。
 *
 * ※この課題に関しては課題実施日によって結果が異なるため、出力結果が個々で異なります。
 *
 */
public class Study {

    public static void main(String args[]) {

        // Dateクラスのインスタンスを生成
        Date now = new Date();

        // 問① ローカル変数「now」を使用し、本日の日付を表示してください。
        System.out.println(now);
        
        // Calendarクラスのインスタンスを生成
        Calendar calendar = Calendar.getInstance();
        // うるう年判定
        printLeapYear(calendar.get(Calendar.YEAR));

        // 問② getメソッドを使って、今日の日付の年、月、日、それぞれの値を出力させて下さい
        // (例) 2020年8月20日→ 2020 8 20
        System.out.println(calendar.get(Calendar.YEAR) + " " + 
        					(calendar.get(Calendar.MONTH) + 1) + " " + 
        					calendar.get(Calendar.DATE));

        // 問③ 上記の「calendar」を使用し、本日から1年2ヶ月15日先の日付を表示しなさい。
        // - この課題に関しては課題実施日によって結果が異なります。
        // - また、うるう年の場合は設定内容が正しくとも日付がズレて表示される可能性があります。
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.DATE, 15);
        
        System.out.println(calendar.get(Calendar.YEAR) + " " + 
				(calendar.get(Calendar.MONTH) + 1) + " " + 
				calendar.get(Calendar.DATE));
        
        // うるう年判定
        printLeapYear(calendar.get(Calendar.YEAR));
    }

    /**
     * うるう年判定
     * 問③で日付がズレる可能性があるため補足として出力
     * @param year
     */
    private static void printLeapYear(final int year) {
        String msg = year + "年は、";
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if ((year % 100) == 0) {
                if ((year % 400) == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        msg += isLeapYear ? "うるう年です。" : "うるう年ではありません。";
        System.out.println(msg);
    }
}

/* コンソール出力結果↓ (一例となります)

Tue Apr 07 13:26:29 JST 2020
2020年はうるう年です。
2020
4
7
2021
6
22
2021年はうるう年ではありません。

 */
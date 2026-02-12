public class Task2_6 {

    public static void main(String[] args) {
        // 問題① 要素数が「5」のint型の配列arrayIntを宣言し、「2,4,6,8,10」で初期化して下さい。
    		
    		int[] arrayInt = {2, 4, 6, 8, 10};

        System.out.println("--- 問題② ---");

        // 問題② arrayInt配列の中から「8」を表示して下さい。
        
        System.out.println(arrayInt[3]);

        /*
        問題③ 以下の2つの配列を作成してください(newでも初期化子でも可)
 
        データ型：String[]
        配列名：jp_animals
        値(この順番で設定)："犬","猫","ねずみ","うさぎ"
 
        データ型：String[]
        配列名：en_animals
        値(この順番で設定)："dog","cat","mouse","rabbit"
      */
        String[] jp_animals = {"犬", "猫", "ねずみ", "うさぎ"};
        String[] en_animals = {"dog", "cat", "mouse", "rabbit"};

        System.out.println("--- 問題④ ---");
        // 問題④ 2つの配列とループ文を使って、
        // 「犬は英語でdogです」「猫は英語でcatです」〜〜
        // という表示を全ての動物分表示させて下さい。
        
        for(int i = 0; i < jp_animals.length; i++) {
        		System.out.println("「" + jp_animals[i] + "は英語で" + en_animals[i] + "」です");
        }

        System.out.println("--- 問題⑤ ---");
        // 問題⑤ 2つの配列とループ文を使って、
        // 「うさぎは英語でrabbitです」「ねずみは英語でmouseです」〜〜
        // と、"問題④とは逆順で、後ろから"表示させて下さい。
        
        for(int i = jp_animals.length - 1; i >= 0; i--) {
    		System.out.println("「" + jp_animals[i] + "は英語で" + en_animals[i] + "」です");
        }

        System.out.println("--- 問題⑥ ---");
        // 問題⑥ for文またはWhile文を使用して、以下の条件に沿った値を出力して下さい。
        // 1～50までの数字を出力
        // 3の倍数のときは、数字の代わりに「Fizz!!!」と出力
        // 5の倍数のときは、数字の代わりに「Buzz!!!」と出力
        // 3の倍数かつ5の倍数のときは「FizzBuzz!!!」と出力
        // それ以外は、そのまま数値を出力
        for(int i = 1; i <= 50; i++) {
        		if(i%3 == 0 && i%5 == 0) {
        			System.out.println("「Fizz!!!」");
        		} else if(i%3 == 0) {
        			System.out.println("「Buzz!!!」");
        		} else if(i%5 == 0){
        			System.out.println("「FizzBuzz!!!」");
        		} else {
        			System.out.println(i);
        		}
        }

        System.out.println("--- 問題⑦ ---");
        // 問題⑦ for文またはWhile文を使用して、以下の条件に沿った値を出力して下さい。
        // ・初期値は0
        // ・0〜50までの数字のうち、偶数のみ出力する
        // ・10の倍数の時は、ビックリマーク3個を付けて出力する 例) "10!!!"
        for(int i = 0; i <= 50; i++) {
        		if(i%10 == 0) {
        			System.out.println(i + "!!!");
        		} else if(i%2 == 0) {
        			System.out.println(i);
        		}
        }

    }

}
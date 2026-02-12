package check;

//3_16課題
//
//課題①
//
//Checkクラスにてフィールド変数lastNameとfirstNameを宣言し、
//firstName →　自分の名前 lastName →　自分の名字
//で初期化して下さい。
//なお、変数のアクセス修飾子はprivateとして下さい。
//staticの付与は任意です。
//
//課題②
//
//Checkクラスにて、String型の2つの引数を受け取り、それらを連結して表示させるprintNameメソッドを作成して下さい。
//メソッドのアクセス修飾子はprivateとして下さい。
//staticの付与は任意です。
//
//printNameメソッドをmainメソッド内で2回実行させて下さい。(最後の出力例も参考にして下さい)
//1.フィールド変数を渡して自分のフルネームを表示させる
//2.Justin Bieberと表示させる
//
//課題③
//
//Checkクラスにて、PetクラスとRobotPetクラスをインスタンス化して下さい
//課題④
//課題⑤
//Pet.java内に記載しています。
//
//課題⑥
//プロジェクトを実行するとコンソールで下記の表示となるよう、メソッドを実行するコードを記載して下さい。
//
//コンソール出力結果例
//
//TarouYamada
//JustinBieber
//■僕の名前はポチです
//■ご主人様は太郎です
//◇私はロボット。名前はアイボです
//◇ご主人様はロボ太郎です

public class Check {
	
	private String firstName = "Tatsuya";
	private String lastName = "Kawamitsu";
	Pet pet = new Pet("ポチ", "太郎");
	RobotPet robotPet = new RobotPet("アイボ", "ロボ太郎");
	
	private void printName(String fName, String lName) {
		System.out.println(fName + lName);
	}
	
	public static void main(String[] args) {
		Check check = new Check();
		check.printName(check.firstName, check.lastName);
		check.printName("Justin", "Bieber");
		
		check.pet.introduce();
		check.robotPet.introduce();
	}
	

}

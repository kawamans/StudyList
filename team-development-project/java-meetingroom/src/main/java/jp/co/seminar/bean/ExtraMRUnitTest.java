package jp.co.seminar.bean;

public class ExtraMRUnitTest {
	public static void main(String[] args) {
		/**=======================================================*/
		/** テスト済みのメソッド 
		 * ☆☆パブリックメソッドは使用している元メソッド内での
		 * テスト完了でテスト代替とする。
		 * 
		 * ①コンストラクタOK
		 * 
		 * 
		 * 
		 * **/
		
		/**=======================================================*/
		/** テスト数 
		totalTest = 0;
		passedTest = 0;
		failedTest = 0;
		
		**/
		/**=======================================================*/

		System.out.println("①コンストラクタのテスト");
		ExtraMR mr = new ExtraMR();
		
		System.out.println(mr);
		
		/**=======================================================*/
		
		System.out.println("②inputUserのテスト");
		System.out.println("＜正常値系＞");
		
		System.out.println("期待する結果："+ "\n"+
		"ユーザー登録情報の生成"+"\n"+
		"id=null, password, 情報太郎, 2000, 名古屋市中区,1"+"\n");
		
		System.out.println("実行結果");
		
		UserBean u = mr.inputUser("password", "情報太郎", "2000", "名古屋市中区", "1");
		System.out.println(u);
		
		System.out.println("\n"+"成功!"+"\n");
		
		/**=======================================================*/
		
		System.out.println("＜異常値系＞");
		
		System.out.println("期待する結果:");
		
		
		/**=======================================================*/
		System.out.println("③createUserのテスト");
		System.out.println("＜正常値系＞");
		
		UserBean user1 = mr.getUser();
		System.out.println("実行前のuser状態"+"\n");
		System.out.println(user1);
		
		System.out.println("期待する結果：実行後のuser状態"+"\n");
		
		System.out.println("実行結果");
		
		UserBean u1 = new UserBean("password", "情報太郎", "2000", "名古屋市中区", "1");
		mr.createUser(u1);
		
		UserBean user2 = mr.getUser();
		System.out.println(user2);
		
		
		
		
}
}

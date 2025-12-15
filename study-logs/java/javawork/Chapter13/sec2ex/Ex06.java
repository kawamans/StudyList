package sec2ex;

public class Ex06 {
	public static void main(String[] args) {
		String postNo = "〒100-0001";
		String maeNo = postNo.substring(1, 4);
		String atoNo = postNo.substring(5, 9);
		
		System.out.println("【前半】"+ maeNo);
		System.out.println("【後半】"+ atoNo);
	}
}

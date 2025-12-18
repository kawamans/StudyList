
public class ForEachTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		
		String[] rgbColor = {"red", "green", "blue"};
		for (String color : rgbColor) {
			System.out.print(color+ " ");
		}
		
		System.out.println("\n--------------");
		
		String[][] multiRgbColor = {{"red", "green", "blue"}, {"赤", "緑", "青"}};
		for (String multiColor : multiRgbColor[0]) {
			System.out.print(multiColor+ " ");
		}
		
		System.out.print("\n");
		
		for (String multiColor : multiRgbColor[1]) {
			System.out.print(multiColor+ " ");
		}
		
		System.out.println("\n--------------");
		
		for (int i = 0; i < rgbColor.length; i++) {
			System.out.print(rgbColor[i]+ " ");
		}
		System.out.println("\n--------------");
		
		int i = 0;
		int j = 0;
		while (j < 2 && i < 3) {
			while (j < 2) {
				System.out.print(multiRgbColor[j][i]+ " ");
				j++;
			}
			i++;
			j = 0;
			System.out.print("\n");
		}
		System.out.print("\n---処理終了---");
	}

}

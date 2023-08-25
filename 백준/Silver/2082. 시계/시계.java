import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] number = {
			Integer.parseInt("111101101101111", 2),
			Integer.parseInt("001001001001001", 2),
			Integer.parseInt("111001111100111", 2),
			Integer.parseInt("111001111001111", 2),
			Integer.parseInt("101101111001001", 2),
			Integer.parseInt("111100111001111", 2),
			Integer.parseInt("111100111101111", 2),
			Integer.parseInt("111001001001001", 2),
			Integer.parseInt("111101111101111", 2),
			Integer.parseInt("111101111001111", 2),
		};
		String[] arr = new String[4];
		
		for (int i = 0; i < 5; i++) {
			String[] sArr = br.readLine().split(" ");
			
			for (int j = 0; j < 4; j++) {
				if (arr[j] == null) {
					arr[j] = "";
				}
				
				sArr[j] = sArr[j].replace('#', '1');
				sArr[j] = sArr[j].replace('.', '0');
				arr[j] += sArr[j];
			}
		}
		
				
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(arr[i], 2);
			
			for (int j = 0; j < 10; j++) {
				if ((num & number[j]) == num) {
					System.out.print(j);
					break;
				}
			}
			
			if (i == 1) {
				System.out.print(":");
			}
		}
		
		System.out.println();
	}
}
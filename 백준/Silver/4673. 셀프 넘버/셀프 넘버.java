public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10_001];
		
		for (int i = 1; i <= 10_000; i++) {
			int sum = i;
			String num = String.valueOf(i);
			
			for (int j = 0; j < num.length(); j++) {
				sum += num.charAt(j) - '0';
			}
			
			if (sum <= 10000) {
				arr[sum]++;
			}
		}
		
		for (int i = 1; i <= 10_000; i++) {
			if (arr[i] == 0) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
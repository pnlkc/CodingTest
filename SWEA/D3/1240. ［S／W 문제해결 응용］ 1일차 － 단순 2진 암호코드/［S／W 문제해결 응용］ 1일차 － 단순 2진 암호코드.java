import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Map<String, Integer> numMap = new HashMap<>();
		numMap.put("0001101", 0);
		numMap.put("0011001", 1);
		numMap.put("0010011", 2);
		numMap.put("0111101", 3);
		numMap.put("0100011", 4);
		numMap.put("0110001", 5);
		numMap.put("0101111", 6);
		numMap.put("0111011", 7);
		numMap.put("0110111", 8);
		numMap.put("0001011", 9);
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			int firstY = 0;
			int lastX = 0;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
					
					if ((firstY == 0 || firstY == i) && map[i][j] != 0) {
						firstY = i;
						lastX = j;
					}
				}
			}
			
			List<Integer> list = new ArrayList<>();
			
			for (int i = lastX - 55; i <= lastX; i += 7) {
				String str = "";
				
				for (int j = 0; j < 7; j++) {
					str += map[firstY][i + j];
				}
				
				list.add(numMap.get(str));
			}
			
			int oddSum = 0;
			int evenSum = 0;
			
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 == 1) {
					evenSum += list.get(i);
				} else {
					oddSum += list.get(i);
				}
			}
			
			int sum = oddSum * 3 + evenSum;
			
			if (sum >= 10 && sum % 10 == 0) {
				System.out.println("#" + tc + " " + (oddSum + evenSum));
			} else {
				System.out.println("#" + tc + " " + "0");
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] inOrder;
	static Map<Integer, Integer> inOrderMap = new HashMap<>();
	static int[] postOrder;
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 중위 순회, 후위 순회 입력값에 따라 배열, 스택 생성
		for (int i = 0; i < n ; i++) {
			inOrder[i] = Integer.parseInt(st1.nextToken());
			inOrderMap.put(inOrder[i], i);
			postOrder[i] = Integer.parseInt(st2.nextToken());
		}
		
		calc(0, n - 1, n - 1);
		
		System.out.println(sb.toString().trim());
	}
	
	public static void calc(int s, int e, int p) {
		if (s == e) {
			sb.append(inOrder[s] + " ");
		} else {
			int tempP = p;
			int idx = inOrderMap.get(postOrder[tempP]);
			
			while (idx == -1 || idx < s || idx > e) {
				idx = inOrderMap.get(postOrder[--tempP]);
			}
			
			sb.append(inOrder[idx] + " ");
			
			if (s <= idx - 1) calc(s, idx - 1, tempP - 1);
			if (idx + 1 <= e) calc(idx + 1, e, tempP - 1);
		}
	}
}
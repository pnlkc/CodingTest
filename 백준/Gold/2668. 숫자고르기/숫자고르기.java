import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2668번 숫자고르기
public class Main {
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			isVisit = new boolean[N + 1];
			isVisit[i] = true;
			dfs(i, i);
			isVisit[i] = false;
		}

		Collections.sort(list);
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void dfs(int num, int target) {
		if (arr[num] == target) {
			list.add(target);
			return;
		}
		
		if (!isVisit[arr[num]]) {
			isVisit[arr[num]] = true;
			dfs(arr[num], target);
			isVisit[arr[num]] = false;
		}
	}
}
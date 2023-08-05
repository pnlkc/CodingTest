import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int N, M;
	static List<Integer> used = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		backtracking(1);
	}

	private static void backtracking(int s) {
		if (used.size() == M) {
			String str = used
					.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" "))
					.trim();
			System.out.println(str);
			
		} else {
			for (int i = s; i <= N; i++) {
				if (!used.contains(i)) {
					used.add(i);
					backtracking(i + 1);
					used.remove(used.size() - 1);
				}
			}
		}
	}
}
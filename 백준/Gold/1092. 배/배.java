import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		crane.sort(Comparator.reverseOrder());
		
		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		box.sort(Comparator.reverseOrder());
		
		int time = 0;
		int cnt = 0;
		int boxIdx = 0;
		int craneIdx = 0;
		boolean[] isDone = new boolean[M];
		
		if (box.get(0) > crane.get(0)) {
			System.out.println(-1);
			return;
		}
		
		while (cnt < M) {
			if (isDone[boxIdx]) {
				if (++boxIdx == M) {
					boxIdx = 0;
					craneIdx = 0;
					time++;
				}
				
				continue;
			}
			
			int c = box.get(boxIdx);
			
			if (c <= crane.get(craneIdx)) {
				isDone[boxIdx] = true;
				boxIdx++;
				craneIdx++;
				cnt++;
			} else {
				boxIdx++;
			}
			
			if (boxIdx == M || craneIdx == N || cnt == M) {
				time++;
				boxIdx = 0;
				craneIdx = 0;
			}
		}
		
		System.out.println(time);
	}
}
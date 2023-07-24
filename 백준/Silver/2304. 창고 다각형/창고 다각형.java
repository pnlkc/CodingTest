import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][];
		int cnt = 0;
		
		// 배열 생성
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[2];
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		// 기둥 높이의 최대값 찾기
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i][1]);
		}
		
		// 높이가 최대인 기둥들 인덱스 가져오기
		for (int i = 0; i < n; i++) {
			if (arr[i][1] == max) al.add(i);
		}
		
		int px = arr[0][0];
		int py = arr[0][1];
		
		for (int i = 0; i <= al.get(0); i++) {
			int cx = arr[i][0];
			int cy = arr[i][1];
			
			cnt += (cx - px) * py;		
			
			px = cx;
			py = Math.max(py, cy);
		}
		
		px = arr[n - 1][0];
		py = arr[n - 1][1];
		
		for (int i = n - 1; i >= al.get(al.size() - 1); i--) {
			int cx = arr[i][0];
			int cy = arr[i][1];
			
			cnt += (px - cx) * py;
				
			px = cx;
			py = Math.max(py, cy);
		}
		
		cnt += (arr[al.get(al.size() - 1)][0] - arr[al.get(0)][0] + 1) * max;
		
		System.out.println(cnt);
	}
}
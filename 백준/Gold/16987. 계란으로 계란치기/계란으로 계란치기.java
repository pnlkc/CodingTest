import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Data[] arr = new Data[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[i] = new Data(s, w);
		}

		calc(0, arr.clone(), 0, N);

		System.out.println(max);
	}

	static void calc(int idx, Data[] arr, int cnt, int N) {
		if (idx == N) {
			return;
		}
		
		if (arr[idx].s <= 0) {
			calc(idx + 1, arr.clone(), cnt, N);
		} else {
			for (int i = 0; i < N; i++) {
				if (i == idx || arr[i].s <= 0) {
					continue;
				}
				
				Data[] temp = new Data[N];
				
				for (int j = 0; j < N; j++) {
					temp[j] = new Data(arr[j].s, arr[j].w);
				}

				temp[idx].s -= temp[i].w;
				temp[i].s -= temp[idx].w;
				
				int newCnt = cnt;

				if (temp[idx].s <= 0) {
					newCnt++;
				}
				
				if (temp[i].s <= 0) {
					newCnt++;
				}
				
				max = Math.max(max, newCnt);
				calc(idx + 1, temp, newCnt, N);
			}
		}
	}
}

class Data {
	int s, w;

	public Data(int s, int w) {
		this.s = s;
		this.w = w;
	}
}
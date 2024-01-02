import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int[] pick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[606061];
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		pick = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[toInt(arr)] = 0;
		calc(arr, 0, dp);
		System.out.println(result);
	}

	// 뮤탈리스크의 쿠션 공격을 수행하는 함수
	public static void calc(int[] arr, int cnt, int[] dp) {
		if (dp[toInt(arr)] < cnt) {
			return;
		}

		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		
		if (sum == 0) {
			result = Math.min(result, cnt);
			return;
		}

		pick(arr, cnt, dp, 0);
	}
	
	// 각 SCV가 받을 데미지를 선택하는 함수
	public static void pick(int[] arr, int cnt, int[] dp, int n) {
		if (n == N) {
			int[] numArr = { 9, 3, 1 };
			int[] newArr = new int[N];
			
			for (int i = 0; i < N; i++) {
				newArr[i] = Math.max(0, arr[i] - numArr[pick[i]]);
			}
			
			if (dp[toInt(newArr)] > cnt + 1) {
				dp[toInt(newArr)] = cnt + 1;
				calc(newArr, cnt + 1, dp);
			}
			
			return;
		}
		
		p: for (int i = 0; i < N; i++) {
			for (int j = 0; j < n; j++) {
				if (pick[j] == i) {
					continue p;
				}
			}
			
			pick[n] = i;
			pick(arr, cnt, dp, n + 1);
		}
	}

	// dp를 위해 arr 배열의 숫자를 인덱스로 바꾸는 함수
	public static int toInt(int[] arr) {
		String[] strArr = new String[N];
		
		for (int i = 0; i < N; i++) {
			String str = String.valueOf(arr[i]);
			
			if (arr[i] < 10) {
				str = "0" + str;
			}
			
			strArr[i] = str;
		}

		return Integer.parseInt(String.join("", strArr));
	}
}

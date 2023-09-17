import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Data {
	int num, idx;

	public Data(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Data> stack1 = new Stack<>(); // 입력값을 저장할 스택
		Stack<Data> stack2 = new Stack<>(); // 수신할 탑을 찾는 탑들을 저장할 스택
		int[] cnt = new int[N]; // 결과를 저장할 배열
		int[] maxArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 배열 초기화
		for (int i = 0; i < N; i++) {
			stack1.push(new Data(Integer.parseInt(st.nextToken()), i + 1));
			
			if (i == 0) {
				maxArr[i] = stack1.peek().num;
			} else {
				maxArr[i] = Math.max(maxArr[i - 1], stack1.peek().num);
			}
		}
		
		stack2.push(stack1.pop());
		
		while (!stack1.isEmpty()) {
			Data c1 = stack1.pop();
			
			while (!stack2.isEmpty()) {
				if (stack2.peek().num < c1.num) {
					cnt[stack2.pop().idx - 1] = c1.idx;
				} else {
					break;
				}
			}
			
			stack2.push(c1);
		}
		
		for (int r : cnt) {
			sb.append(r + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
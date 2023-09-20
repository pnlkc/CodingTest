import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		long[] arr = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree segmentTree = new SegmentTree(N);
		segmentTree.init(arr, 1, 1, N);
		
		for (int i = 0; i < M + K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			long c = Long.parseLong(st2.nextToken());
			
			if (a == 1) {
				segmentTree.updateDiff(arr, 1, 1, N, b, c - arr[b]);
			} else {
				sb.append(segmentTree.preSum(1, 1, N, b, (int) c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}

class SegmentTree {
	long[] tree;
	
	public SegmentTree(int n) {
		int h = ((int) (Math.log(n) / Math.log(2))) + 1;
		int cnt = (int) Math.pow(2, h + 1);
		tree = new long[cnt + 1];
	}
	
	void init(long[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			init(arr, node * 2, start, (start + end) / 2);
			init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}
	
	// [start,end] : 노드의 구간, [left,right] : 누적합을 구할 구간
	long preSum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) { // 1. [left,right]와 [start,end]가 겹치지 않는 경우
			return 0L;
		}
		
		if (left <= start && right >= end) { // 2. [left,right]가 [start,end]를 완전히 포함하는 경우
			return tree[node];
		}
		
		// 3. [start,end]가 [left,right]를 완전히 포함하는 경우
		// 4. [left,right]와 [start,end]가 겹쳐져 있는 경우 (1, 2, 3 제외한 나머지 경우)
		long lSum = preSum(node * 2, start, (start + end) / 2, left, right);
		long rSum = preSum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		
		return lSum + rSum;
	}
	
	void updateDiff(long[] arr, int node, int start, int end, int idx, long diff) {
		if (idx < start || end < idx) {
			return;
		}
		
		tree[node] += diff;
		
		if (start != end) {
			updateDiff(arr, node * 2, start, (start + end) / 2, idx, diff);
			updateDiff(arr, node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		} else {
			arr[idx] += diff;
		}
	}
}
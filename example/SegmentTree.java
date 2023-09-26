// 세그먼트 트리(Segment Tree)
// 세그먼트 트리는 특정 구간의 데이터 정보(구간합, 최솟값, 최댓값 등)를 처리하는데 유용한 자료구조입니다
// 세그먼트 트리는 트리 중 정이진트리의 형태를 가집니다
// 세그먼트 트리는 정이진트리의 형태이므로 node의 자식 노드는 node * 2, node * 2 + 1이 됩니다
//
// 세그먼트 트리의 시간 복잡도는 아래와 같습니다
// init : Nlong(N)
// preSum, update : log(N)
//
// ex) 백준 2042번 구간 합 구하기
public class SegmentTree {
	long[] tree;

	// 세그먼트 트리를 적당한 크기로 생성
	public SegmentTree(int n) {
		int h = ((int) (Math.log(n) / Math.log(2))) + 1;
		int cnt = (int) Math.pow(2, h + 1);
		tree = new long[cnt];
	}

	// 세그먼트 트리 초기화
	// 시작은 start = 1, end = N
	void init(long[] arr, int node, int start, int end) {
		if (start == end) { // 리프 노드인 경우
			tree[node] = arr[start];
		} else { // 리프 노드가 아닌 경우
			init(arr, node * 2, start, (start + end) / 2); // 좌측 서브 트리
			init(arr, node * 2, (start + end) / 2 + 1, end); // 우측 서브 트리
			tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 현재 트리 = 좌측 트리 + 우측 트리
		}
	}

	// 세그먼트 트리를 통해 구간합 구하기
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
	
	
	// 방법1. 변경된 값에 해당하는 리프노드를 직접 수정 후 부모 노들를 자식 노드를 통해 갱신하는 방식
	void update(long[] arr, int node, int start, int end, int idx, int num) {
		if (start > idx || end < idx) { // 현재 트리에 변경된 값이 포함되지 않은 경우
			return;
		}
		
		if (start == idx && end == idx) { // 변경된 값에 해당하는 리프 노드인 경우
			tree[node] = num;
			arr[idx] = num;
			return;
		}
		
		update(arr, node * 2, start, (start + end) / 2, idx, num);
		update(arr, node * 2 + 1, (start + end) / 2 + 1, end, idx, num);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	// 방법2. 변경된 값을 포함하는 모든 트리를 변경된 값의 차이만큼 갱신하는 방식
	void updateDiff(long[] arr, int node, int start, int end, int idx, int diff) {
		if (idx < start || end < idx) { // 현재 트리에 변경된 값이 포함되지 않은 경우
			return;
		}
		
		tree[node] += diff;
		
		if (start != end) { // 변경된 값에 해당하는 리프 노드가 아닌 경우
			updateDiff(arr, node * 2, start, (start + end) / 2, idx, diff);
			updateDiff(arr, node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		} else { // 변경된 값에 해당하는 리프 노드인 경우
			arr[idx] += diff;
		}
	}
}

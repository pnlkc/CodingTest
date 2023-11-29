// 느리게 갱신되는 세그먼트 트리(Segment Tree With Lazy Propagation)입니다
// 기본적인 개념은 세그먼트 트리와 동일하지만 변경되는 값을 바로 갱신하는 것이 아니라
// lazy 배열에 저장하고 해당 노드가 호출될 때 갱신하는 방법입니다
// 구간을 변경하고, 구간합을 구하는 과정 모두 O(logN)의 시간복잡도를 가집니다
public class SegmentTreeWithLazyPropagation {
	BigInteger[] tree;
	BigInteger[] lazy; // 변경 값을 보관하고 있을 배열
	
	public ST(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new BigInteger[cnt];
		lazy = new BigInteger[cnt];
		
		Arrays.fill(tree, BigInteger.ZERO);
		Arrays.fill(lazy, BigInteger.ZERO);
	}
	
	public void init(BigInteger[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[e];
			return;
		}
		
		init(arr, node * 2 , s, (s + e) / 2);
		init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
		
		tree[node] = tree[node * 2].add(tree[node * 2 + 1]);
	}

  	// lazy 배열 갱신 메소드
	public void updateLazy(int node, int s, int e) {
		if (lazy[node] != BigInteger.ZERO) {
			tree[node] = tree[node].add(lazy[node].multiply(BigInteger.valueOf(e - s + 1)));
			
			if (s != e) {
				lazy[node * 2] = lazy[node * 2].add(lazy[node]);
				lazy[node * 2 + 1] = lazy[node * 2 + 1].add(lazy[node]);
			}
			
			lazy[node] = BigInteger.ZERO;
		}
	}
	
	public BigInteger preSum(BigInteger[] arr, int node, int s, int e, int l, int r) {
		updateLazy(node, s, e); // 갱신할 값이 있는지 lazy 배열 확인 
		
		if (r < s || l > e) {
			return BigInteger.ZERO;
		}
		
		if (l <= s && e <= r) {
			return tree[node];
		}
		
		BigInteger lSum = preSum(arr, node * 2, s, (s + e) / 2, l, r);
		BigInteger rSum = preSum(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		
		return lSum.add(rSum);
	}
	
	public void change(BigInteger[] arr, int node, int s, int e, int l, int r, BigInteger diff) {
		updateLazy(node, s, e); // 갱신할 값이 있는지 lazy 배열 확인 
		
		if (r < s || e < l) {
			return;
		}
		
		if (l <= s && e <= r) {
			tree[node] = tree[node].add(diff.multiply(BigInteger.valueOf(e - s + 1)));
			
			if (s != e) {
				lazy[node * 2] = lazy[node * 2].add(diff);
				lazy[node * 2 + 1] = lazy[node * 2 + 1].add(diff);
			}
			
			return;
		}
		
		change(arr, node * 2, s, (s + e) / 2, l, r, diff);
		change(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r, diff);
		
		tree[node] = tree[node * 2].add(tree[node * 2 + 1]);
	}
}

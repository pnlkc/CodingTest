import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int parent;
	int value;
	Node left;
	Node right;

	public Node(int parent, int value) {
		this.parent = parent;
		this.value = value;
	}

	// 해당 노드를 찾는 메소드
	public Node find(int value) {
		if (this.value == value) { // 현재 노드가 찾는 노드인 경우
			return this;
		}

		if (left != null) { // 왼쪽에 자식 노드가 있는 경우
			Node r = left.find(value); // 왼쪽 서브트리 탐색 결과
			if (r != null)
				return r; // 원하는 노드를 찾은 경우 반환
		}

		if (right != null) { // 오른쪽에 자식 노드가 있는 경우
			Node r = right.find(value); // 오른쪽 서브트리 탐색 결과
			if (r != null)
				return r; // 원하는 노드를 찾은 경우 반환
		}

		return null; // 찾는 노드가 없는 경우
	}
}

public class Solution {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st1.nextToken());
			int B = Integer.parseInt(st1.nextToken());
			Node[] nodeList = new Node[V + 1];
			Node tree = new Node(0, 1);
			nodeList[1] = tree;
			cnt = 0;

			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st2.nextToken());
				int child = Integer.parseInt(st2.nextToken());
				
				if (nodeList[parent] == null) {
					nodeList[parent] = new Node(0, parent);
				}
				
				if (nodeList[child] == null) {
					nodeList[child] = new Node(parent, child);
				}
				
				if (nodeList[child].parent != parent) {
					nodeList[child].parent = parent;
				}
				
				if (nodeList[parent].left == null) {
					nodeList[parent].left = nodeList[child];
				} else {
					nodeList[parent].right = nodeList[child];
				}
			}

			Queue<Integer> qa = new LinkedList<>();
			List<Integer> qb = new ArrayList<>();

			Node a = tree.find(A);
			Node b = tree.find(B);

			while (a.parent != 0) {
				a = tree.find(a.parent);
				qa.offer(a.value);
			}

			while (b.parent != 0) {
				b = tree.find(b.parent);
				qb.add(b.value);
			}

			int same = 0;
			p: while (!qa.isEmpty()) {
				int ca = qa.poll();

				for (int i = 0; i < qb.size(); i++) {
					if (ca == qb.get(i)) {
						same = ca;
						break p;
					}
				}
			}

			Node sameNode = tree.find(same);
			calc(sameNode);

			System.out.println("#" + tc + " " + sameNode.value + " " + cnt);
		}
	}

	public static void calc(Node node) {
		cnt++;
		if (node.left != null)
			calc(node.left);
		if (node.right != null)
			calc(node.right);
	}
}
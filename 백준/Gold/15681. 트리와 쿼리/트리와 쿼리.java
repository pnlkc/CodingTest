import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
	int num;
	int parent;
	List<Node> children = new ArrayList<>();

	public Node(int num) {
		this.num = num;
	}
}

class P {
	int u, v;

	public P(int u, int v) {
		this.u = u;
		this.v = v;
	}
}

public class Main {
	static int N, R, Q;
	static Node[] nodeArr;
	static int[] size;
	static Map<Integer, List<Integer>> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		R = Integer.parseInt(st1.nextToken());
		Q = Integer.parseInt(st1.nextToken());
		nodeArr = new Node[N + 1];
		size = new int[N + 1];
		Arrays.fill(size, 1);
		map = new HashMap<>();

		for (int i = 0; i <= N; i++) {
			nodeArr[i] = new Node(i);
			map.put(i, new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st2.nextToken());
			int V = Integer.parseInt(st2.nextToken());
			
			map.get(U).add(V);
			map.get(V).add(U);
		}

		Node tree = nodeArr[R];
		makeTree(tree, nodeArr[0]);
		countSize(tree);
		
		for (int i = 0; i < Q; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(size[num]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void makeTree(Node node, Node parent) {
		for (int child : map.get(node.num)) {
			if (child != parent.num) {
				nodeArr[node.num].children.add(nodeArr[child]);
				nodeArr[child].parent = node.num;
				makeTree(nodeArr[child], node);
			}
		}
	}
	
	public static void countSize(Node node) {
		for (Node n : node.children) {
			countSize(n);
			size[node.num] += size[n.num];
		}
	}
}
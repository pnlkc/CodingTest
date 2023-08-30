import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] arr = new String[K];

			for (int j = 0; j < K; j++) {
				arr[j] = st.nextToken();
			}
			
			trie.add(arr);
		}
		

		trie.print();
	}
}

class TrieNode {
	Map<String, TrieNode> childNodes = new HashMap<>();
	boolean isLast;
}

class Trie {
	TrieNode root = new TrieNode();

	void add(String[] arr) {
		TrieNode node = root;

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			node = node.childNodes.computeIfAbsent(str, key -> new TrieNode());
		}

		node.isLast = true;
	}

	void print() {
		print(root, 0);
	}

	private void print(TrieNode node, int d) {
		if (!node.childNodes.isEmpty()) {
			List<String> list = new ArrayList<>(node.childNodes.keySet());
			Collections.sort(list);
			
			for (String str : list) {
				for (int i = 0; i < d; i++) {
					System.out.print("--");
				}
				
				System.out.println(str);
				
				print(node.childNodes.get(str), d + 1);
			}
		}
	}
}
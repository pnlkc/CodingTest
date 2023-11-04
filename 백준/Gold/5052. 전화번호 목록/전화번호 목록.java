import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		p: for (; t > 0; t--) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
		
			Trie trie = new Trie();
			
			for (String str : arr) {
				if (!trie.check(str)) {
					sb.append("NO\n");
					continue p;
				}
			}
			
			sb.append("YES\n");
		}
		
		System.out.println(sb);
	}
}

class Trie {
	Node root = new Node();
	
	boolean check(String str) {
		Node node = root;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			node = node.children.computeIfAbsent(c, key -> new Node());
			if (node.isEnd) {
				return false;
			}
		}
		
		node.isEnd = true;
		return true;
	}
}

class Node {
	Map<Character, Node> children = new HashMap<>();
	boolean isEnd;
}
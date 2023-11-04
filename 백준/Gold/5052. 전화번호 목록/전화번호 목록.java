import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (; t > 0; t--) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			boolean isNo = false;
			
			for (int i = 0; i < n; i++) {
				if (isNo) {
					br.readLine();
					continue;
				}
				
				if (!trie.check(br.readLine())) {
					sb.append("NO\n");
					isNo = true;
				}
			}
			
			if (isNo) {
				continue;
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
		
		if (!node.children.isEmpty()) {
			return false;
		}
		
		node.isEnd = true;
		return true;
	}
}

class Node {
	Map<Character, Node> children = new HashMap<>();
	boolean isEnd;
}
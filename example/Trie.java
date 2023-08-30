// 트라이의 노드
class TrieNode {
	Map<Character, TrieNode> childNodes = new HashMap<>();
	boolean isLast;
}

// 트라이
class Trie {
	TrieNode root = new TrieNode();

	// 추가하는 메소드
	void add(String str) {
		TrieNode node = root;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// computeIfAbsent -> 해당 key에 대한 value가 있으면 반환, 없으면 뒤에 함수 실행 후 반환
			node = node.childNodes.computeIfAbsent(c, key -> new TrieNode());
		}

		node.isLast = true;
	}

	// 포함되어 있는지 확인하는 메소드
	boolean contains(String str) {
		TrieNode node = root;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			node = node.childNodes.get(c);
			
			if (node == null) { // 현재 번호에 해당하는 문자가 없는 경우
				return false;
			}
		}

		return node.isLast; // 해당 단어가 마지막인지 체크해서 완성된 단어인지 확인해야 됨
	}

	// 삭제하는 메소드
	void remove(String str) {
		remove(root, str, 0); // remove(TrieNode node, String str, int idx) 실행
	}

	// 실제로 재귀적으로 동작하며 삭제하는 메소드
	private void remove(TrieNode node, String str, int idx) {
		if (idx == str.length()) { // 문자열의 마지막까지 전부 탐색한 경우
			if (node.isLast) { // 다른 문자의 접두사인 경우 처리
				node.isLast = false; // isLast를 false로 변경
			}
			return;
		}

		char c = str.charAt(idx);

		if (node.childNodes.containsKey(c)) {
			TrieNode child = node.childNodes.get(c);
			
			remove(child, str, idx + 1); // 자식 노드에서 다음 문자 삭제 호출

			// child.childNodes.isEmpty() -> 자식 노드가 하나도 없는 마지막 문자인 경우
			// !child.isLast -> 해당 문자를 끝으로 하는 다른 문자열이 없는 경우
			if (child.childNodes.isEmpty() && !child.isLast) {
				node.childNodes.remove(c, child); // 해당 노드(문자) 삭제
			}
		}
	}
}

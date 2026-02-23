fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trie = Trie()
    var cnt = 0

    for (i in 0 until n) {
        trie.add(readln())
    }

    for (i in 0 until m) {
        if (trie.contains(readln())) cnt++
    }

    println(cnt)
}

class TrieNode {
    var cN: MutableMap<Char?, TrieNode> = HashMap<Char?, TrieNode>()
}

// 트라이
class Trie {
    var root: TrieNode = TrieNode()

    fun add(str: String) {
        var node = root

        for (i in 0..<str.length) {
            val c = str[i]
            node = node.cN.computeIfAbsent(c) { TrieNode() }
        }
    }

    fun contains(str: String): Boolean {
        var node: TrieNode? = root

        for (i in 0..<str.length) {
            val c = str[i]

            node = node!!.cN[c]
            if (node == null) return false
        }

        return true
    }
}
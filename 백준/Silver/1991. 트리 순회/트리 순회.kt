import java.util.LinkedList

data class Node(var data: Char, var left: Node?, var right: Node?)

fun main() {
    val sb = StringBuilder()
    val tree = makeTree()

    preOrder(tree, sb)
    sb.appendLine()
    inOrder(tree, sb)
    sb.appendLine()
    postOrder(tree, sb)

    println(sb)
}

fun makeTree(): Node {
    val n = readln().toInt()
    val map = mutableMapOf<Char, Pair<Char, Char>>()

    repeat(n) {
        val (d, l, r) = readln().split(' ').map { it[0] }
        map[d] = l to r
    }

    val tree = Node('A', null, null)
    val queue = LinkedList<Node>()
    queue.add(tree)

    while (queue.isNotEmpty()) {
        val c = queue.poll()!!
        val (left, right) = map[c.data]!!

        if (left != '.') c.left = Node(left,null, null)
        c.left?.let { queue.add(it) }

        if (right != '.') c.right = Node(right, null, null)
        c.right?.let { queue.add(it) }
    }

    return tree
}

fun preOrder(node: Node, sb: StringBuilder) {
    sb.append(node.data)
    if (node.left != null) preOrder(node.left!!, sb)
    if (node.right != null) preOrder(node.right!!, sb)
}

fun inOrder(node: Node, sb: StringBuilder) {
    if (node.left != null) inOrder(node.left!!, sb)
    sb.append(node.data)
    if (node.right != null) inOrder(node.right!!, sb)
}

fun postOrder(node: Node, sb: StringBuilder) {
    if (node.left != null) postOrder(node.left!!, sb)
    if (node.right != null) postOrder(node.right!!, sb)
    sb.append(node.data)
}
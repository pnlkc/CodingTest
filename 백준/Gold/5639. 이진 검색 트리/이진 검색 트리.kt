import java.io.BufferedReader
import java.io.InputStreamReader

data class MyNode(val num: Int, var left: MyNode? = null, var right: MyNode? = null)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tree = MyNode(br.readLine()!!.toInt())
    val sb = StringBuilder()

    while (true) {
        val input = br.readLine()?.toInt() ?: break
        addNode(tree, input)
    }

    postOrder(tree, sb)

    println(sb)
}

fun postOrder(tree: MyNode, sb: StringBuilder) {
    if (tree.left != null) postOrder(tree.left!!, sb)
    if (tree.right != null) postOrder(tree.right!!, sb)
    sb.appendLine(tree.num)
}

fun addNode(node: MyNode, num: Int) {
    if (node.num > num) {
        if (node.left == null) node.left = MyNode(num) else addNode(node.left!!, num)
    } else {
        if (node.right == null) node.right = MyNode(num) else addNode(node.right!!, num)
    }
}
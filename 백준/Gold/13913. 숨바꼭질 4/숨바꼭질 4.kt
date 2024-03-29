import java.util.LinkedList

fun main() {
    val (n, k) = readln().split(' ').map(String::toInt)
    val queue = LinkedList<Pair<Int, Int>>()
    val map = mutableMapOf<Int, Pair<Int, Int>>()
    queue.add(n to 0)
    map[n] = 0 to -1

    while (queue.isNotEmpty()) {
        val (cn, cd) = queue.poll()!!

        if (map[cn]!!.first < cd) continue
        if (cn == k) break

        val logic: (Int) -> Unit = { nextNum ->
            if (map[nextNum] == null || map[nextNum]!!.first > cd + 1) {
                map[nextNum] = cd + 1 to cn
                queue.add(nextNum to cd + 1)
            }
        }

        if (cn < k) {
            logic(cn + 1)
            logic(cn * 2)
        }

        if (cn > 0) logic(cn - 1)
    }

    var current = map[k]
    val iArr = IntArray(current!!.first + 1)
    iArr[current.first] = k
    var idx = iArr.lastIndex - 1

    while (idx >= 0) {
        iArr[idx--] = current!!.second
        current = map[current.second]
    }

    println(map[k]!!.first)
    println(iArr.joinToString(" "))
}
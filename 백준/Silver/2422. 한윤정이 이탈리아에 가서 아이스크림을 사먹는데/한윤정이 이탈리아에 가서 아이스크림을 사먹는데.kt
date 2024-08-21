val pick = IntArray(3)
val map = mutableMapOf<Int, MutableList<Int>>()
var cnt = 0

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    for (i in 1..N) {
        map[i] = mutableListOf()
    }

    for (i in 0 until M) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        map[a]!!.add(b)
        map[b]!!.add(a)
    }

    pick(0, 1, N)

    println(cnt)
}

fun pick(idx: Int, num: Int, n: Int) {
    if (idx > 2 || num > n) {
        if (!pick.contains(0)) cnt++
        return
    }

    var isPossible = true

    for (i in 0..idx) {
        if (map[num]!!.contains(pick[i])) {
            isPossible = false
            break
        }
    }

    if (isPossible) {
        pick[idx] = num
        pick(idx + 1, num + 1, n)
        pick[idx] = 0
    }

    pick (idx, num + 1, n)
}
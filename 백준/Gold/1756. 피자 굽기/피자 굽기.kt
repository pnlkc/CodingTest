fun main() {
    val (D, N) = readln().split(" ").map { it.toInt() }
    val depth = readln().split(" ").map { it.toInt() }.toMutableList()
    val pizza = readln().split(" ").map { it.toInt() }

    for (i in 0 until depth.lastIndex) {
        if (depth[i] < depth[i + 1]) depth[i + 1] = depth[i]
    }

    var lastIdx = depth.lastIndex

    for (r in pizza) {
        lastIdx = find(depth, lastIdx, r) - 1
        if (lastIdx < 0) {
            println(0)
            return
        }
    }

    println(lastIdx + 2)
}

fun find(depth: List<Int>, lastIdx: Int, r: Int): Int {
    var s = 0
    var e = lastIdx

    while (s <= e) {
        val mid = (s + e) / 2

        when {
            depth[mid] < r -> {
                e = mid - 1
            }
            depth[mid] >= r -> {
                s = mid + 1
            }
        }
    }

    return (s + e) / 2
}
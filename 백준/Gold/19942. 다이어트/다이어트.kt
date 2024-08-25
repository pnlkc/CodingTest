var N = 0
var target = listOf<Int>()
var arr = arrayOf<List<Int>>()
val list = mutableListOf<Int>()
var min = Int.MAX_VALUE
var result = mutableListOf<String>()

fun main() {
    N = readln().toInt()
    target = readln().split(" ").map { it.toInt() }
    arr = Array(N + 1) { List(5) { 0 } }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }
        arr[i + 1] = input
    }

    pick(1, 0, 0, 0, 0, 0)

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
        println(result.minOf { it })
    }
}

fun pick(idx: Int, p: Int, f: Int, s: Int, v: Int, sum: Int) {
    if (sum > min) return

    if (idx > N) {
        if (p >= target[0] && f >= target[1] && s >= target[2] && v >= target[3]) {
            if (sum < min) {
                min = sum
                result.clear()
            }

            result.add(list.joinToString(" "))
        }
        return
    }

    pick(idx + 1, p, f, s, v, sum)

    list.add(idx)
    pick(
        idx + 1,
        p + arr[idx][0],
        f + arr[idx][1],
        s + arr[idx][2],
        v + arr[idx][3],
        sum + arr[idx][4]
    )
    list.removeLast()
}
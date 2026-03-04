fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val pos = IntArray(n + 1) { -1 }
    var result = 0

    for (i in 0 until n * 2) {
        if (pos[list[i]] == -1) {
            pos[list[i]] = i
        } else {
            result = maxOf(result, i - pos[list[i]] - 1)
        }
    }

    println(result)
}
import kotlin.math.abs

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val lList = readln().split(" ").map { it.toInt() }
    var cnt = 0

    for (tc in 1 until N) {
        var diff = 0
        val list = readln().split(" ").map { it.toInt() }

        for (i in 0 until M) {
            diff += abs(lList[i] - list[i])
        }

        if (diff > 2000) {
            if (++cnt * 2 >= N - 1) {
                println("YES")
                return
            }
        }
    }

    println("NO")
}
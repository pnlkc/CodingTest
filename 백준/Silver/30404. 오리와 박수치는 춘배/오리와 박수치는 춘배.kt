fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var time = 0
    var cnt = 0

    for (i in 0 until N) {
        if (list[i] > time) {
            time = list[i] + K
            cnt++
        }
    }

    println(cnt)
}
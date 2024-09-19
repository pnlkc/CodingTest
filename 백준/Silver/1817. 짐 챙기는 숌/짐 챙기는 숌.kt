fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    if (N == 0) {
        println(0)
        return
    }
    val list = readln().split(" ").map { it.toInt() }
    var result = 1
    var box = 0

    for (i in 0 until N) {
        if (box + list[i] > M) {
            result++
            box = list[i]
        } else {
            box += list[i]
        }
    }

    println(result)
}
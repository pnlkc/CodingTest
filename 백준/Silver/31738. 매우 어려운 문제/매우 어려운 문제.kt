fun main() {
    val (N, M) = readln().split(" ").map { it.toLong() }

    if (N >= M) {
        println(0)
        return
    }

    var result = 1L

    for (i in 2..N) {
        result = (result * i) % M
    }

    println(result)
}
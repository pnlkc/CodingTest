fun main() {
    val n = readln().toInt()
    val aL = readln().split(" ").map { it.toInt() }
    val (b, c) = readln().split(" ").map { it.toInt() }
    var result = 0L

    for (a in aL) {
        result += if (a <= b) {
            1
        } else {
            1 + (a - b) / c + if ((a - b) % c != 0) 1 else 0
        }
    }

    println(result)
}
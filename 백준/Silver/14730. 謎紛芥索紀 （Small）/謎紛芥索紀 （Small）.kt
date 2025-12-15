fun main() {
    val n = readln().toInt()
    var num = 0

    repeat(n) {
        val (c, k) = readln().split(" ").map { it.toInt() }

        num += c * k
    }

    println(num)
}
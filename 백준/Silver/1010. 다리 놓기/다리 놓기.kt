fun main() {
    val tcN = readln().toInt()
    repeat(tcN) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var sum = 1
        for (i in 1..n) {
            sum = sum * (m - n + i) / i
        }
        println(sum)
    }
}
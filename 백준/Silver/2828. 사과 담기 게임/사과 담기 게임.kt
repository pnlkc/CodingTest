fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val J = readln().toInt()
    var range = 1..M
    var result = 0

    for (j in 1..J) {
        val pos = readln().toInt()

        if (pos in range) continue

        if (pos < range.first) {
            result += range.first - pos
            range = (pos)..(range.last - (range.first - pos))
        } else if (pos > range.last) {
            result += pos - range.last
            range = (range.first + (pos - range.last))..(pos)
        }
    }

    println(result)
}
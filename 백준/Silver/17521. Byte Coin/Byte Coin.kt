fun main() {
    val (n, w) = readln().split(" ").map { it.toInt() }
    var minP = readln().toInt()
    var maxP = minP
    var result = w.toLong()

    repeat(n - 1) {
        val s = readln().toInt()

        if (s > maxP) {
            maxP = s
        } else if (s < maxP) {
            result = result % minP + result / minP * maxP
            minP = s
            maxP = s
        }
    }

    result = result % minP + result / minP * maxP

    println(result)
}
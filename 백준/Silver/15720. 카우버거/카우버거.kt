fun main() {
    val (B, C, D) = readln().split(" ").map { it.toInt() }
    val bL = readln().split(" ").map { it.toInt() }.sortedDescending()
    val cL = readln().split(" ").map { it.toInt() }.sortedDescending()
    val dL = readln().split(" ").map { it.toInt() }.sortedDescending()
    val min = minOf(B, C, D)
    val max = maxOf(B, C, D)
    var sum1 = bL.sum() + cL.sum() + dL.sum()
    var sum2 = 0

    for (i in 0 until max) {
        if (i < min) {
            val sum = bL[i] + cL[i] + dL[i]
            sum2 += sum / 10 * 9
        } else {
            if (i < B) sum2 += bL[i]
            if (i < C) sum2 += cL[i]
            if (i < D) sum2 += dL[i]
        }
    }

    println(sum1)
    println(sum2)
}
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val aSum = if (a < 0) -((1 + -a) * -a / 2) else (1 + a) * a / 2
    val bSum = if (b < 0) -((1 + -b) * -b / 2) else (1 + b) * b / 2
    
    println(
        when {
            aSum < 0 && bSum < 0 -> minOf(aSum, bSum) - maxOf(aSum, bSum) + maxOf(a, b)
            aSum > 0 && bSum > 0 -> maxOf(aSum, bSum) - minOf(aSum, bSum) + minOf(a, b)
            else -> aSum + bSum
        }
    )
}
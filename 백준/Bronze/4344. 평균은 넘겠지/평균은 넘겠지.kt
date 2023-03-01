import java.text.DecimalFormat

fun main() {
    val testNum = readln().toInt()

    repeat(testNum) {
        val input = readln().split(" ").map { it.toInt() }
        val slice = input.slice(1..input.lastIndex)
        val avg = slice.sum() / input[0]
        val num = slice.count { it > avg }
        val result = num.toDouble() / input[0] * 100
        println(DecimalFormat("##0.000").format(result) + "%")
    }
}

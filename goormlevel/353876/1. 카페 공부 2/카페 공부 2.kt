// https://level.goorm.io/exam/353876/%EC%B9%B4%ED%8E%98-%EA%B3%B5%EB%B6%80-2/quiz/1

fun main() {
    val (h, w) = readLine()!!.trim().split(" ").map { it.toInt() }
    val (x1, y1) = readLine()!!.trim().split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.trim().split(" ").map { it.toInt() }
    val min = minOf(h, w)
    val max = maxOf(h, w)
    val list = listOf(
        listOf(x1 + x2, maxOf(y1, y2)).sorted(),
        listOf(x1 + y2, maxOf(y1, x2)).sorted(),
        listOf(y1 + x2, maxOf(x1, y2)).sorted(),
        listOf(y1 + y2, maxOf(x1, x2)).sorted(),
    )

    for (i in 0..3) {
        if (list[i][0] <= min && list[i][1] <= max) {
            println(x1 * y1 + x2 * y2)
            return
        }
    }

    println(0)
}

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { longArrayOf() }
    var num = 0L

    repeat (n) {
        val (x, y) = readln().split(" ").map(String::toLong)
        arr[it] = longArrayOf(x, y)
    }

    // 다각형을 삼각형으로 쪼갠 후 신발끈 공식으로 삼각형 넓이 구하기
    // 1. 한 점을 고정한 후 나머지 점들을 2개씩 골라 삼각형으로 만들기
    // 2. 신발끈 공식으로 삼각형 넓이 구하기
    for (i in 1 until n - 1) {
        val n1 = arr[0][0] * arr[i][1] + arr[i][0] * arr[i + 1][1] + arr[i + 1][0] * arr[0][1]
        val n2 = arr[0][1] * arr[i][0] + arr[i][1] * arr[i + 1][0] + arr[i + 1][1] * arr[0][0]
        num += n1 - n2
    }

    val numToDouble = abs(num) / 2.0

    println(String.format("%.1f", numToDouble))
}
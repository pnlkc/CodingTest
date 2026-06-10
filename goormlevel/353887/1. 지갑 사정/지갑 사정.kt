// https://level.goorm.io/exam/353887/%EC%A7%80%EA%B0%91-%EC%82%AC%EC%A0%95/quiz/1

fun main() {
    val (a, b, x, y) = readLine()!!.split(" ").map { it.toInt() }

    println(a * x + b * y)
}

// https://level.goorm.io/exam/355187/%EC%B5%9C%EA%B3%A0%EC%9D%98-%EA%B2%80%EC%82%AC/quiz/1

fun main() {
    val (x1, y1) = readLine()!!.split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.split(" ").map { it.toInt() }
    val (x3, y3) = readLine()!!.split(" ").map { it.toInt() }

    val result = (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)

    println(if (result) "YES" else "NO")
}

// https://level.goorm.io/exam/355201/%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95-%EC%AA%BD%EC%A7%80/quiz/1
// 해당 문제는 S가 정사각형의 넓이가 아니라 한변의 길이로 제출해야 통과가 됩니다

fun main() {
    val (w, h) = readLine()!!.trim().split(" ").map { it.toInt() }
    val a = minOf(2 * w, 6 * h)
    val b = minOf(3 * w, 3 * h)
    val c = minOf(6 * w, 2 * h)
    val max = maxOf(a, b, c)

    println(max)
}

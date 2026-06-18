// https://level.goorm.io/exam/353888/%EB%AC%B8%EC%9E%90%EC%97%B4-%EA%B1%B0%EB%A6%AC/quiz/1

fun main() {
    val l = readLine()!!.toInt()
    val a = readLine()!!
    val b = readLine()!!
    var r = 0

    for (i in 0 until l) {
        if (a[i] != b[i]) r++
    }

    println(r)
}

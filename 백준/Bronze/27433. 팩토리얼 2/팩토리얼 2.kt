fun main() {
    calc(1L, readln().toInt())
}

fun calc(answer: Long, i: Int) {
    if (i <= 1) println(answer) else calc(answer * i, i - 1)
}
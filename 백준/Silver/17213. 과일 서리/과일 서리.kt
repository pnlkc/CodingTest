fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    var r = M - N
    val a = r + N - 1

    if (a - r < r) r = a - r

    var top = 1L
    var bot = 1L

    for (i in a downTo a - r + 1) {
        top *= i
    }

    for (i in 1..r) {
        bot *= i
    }

    println(top / bot)
}
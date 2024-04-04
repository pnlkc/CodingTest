var min = Int.MAX_VALUE

fun main() {
    val (A, B) = readln().split(" ")

    calc(A, B)
    println(min)
}

fun calc(a: String, b: String) {
    for (i in b.indices) {
        if (i + a.length > b.length) break

        val newA = b.replaceRange(i until i + a.length, a)
        min = minOf(min, check(newA, b))
    }
}

fun check(a: String, b: String): Int {
    var cnt = 0

    for (i in a.indices) {
        if (a[i] != b[i]) cnt++
    }

    return cnt
}
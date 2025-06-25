fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<String, Boolean>()
    var prev = " "
    var find = false
    var s = ' '
    var e = ' '

    for (i in 0 until N) {
        val S = readln()

        if (S == "?") {
            s = prev.last()
            find = true
        } else if (find) {
            e = S[0]
            find = false
        }

        prev = S
        map[S] = true
    }

    val M = readln().toInt()

    for (i in 0 until M) {
        val A = readln()

        if (map[A] == null && (s == ' ' || A[0] == s) && (e == ' ' || A.last() == e)) {
            println(A)
            return
        }
    }
}
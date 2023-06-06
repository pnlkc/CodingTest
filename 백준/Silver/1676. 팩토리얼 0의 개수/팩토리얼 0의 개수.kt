fun main() {
    val num = readln().toBigInteger()
    var idx = 1.toBigInteger()
    var f = 1.toBigInteger()

    while (idx <= num) {
        f *= idx
        idx++
    }

    val s = f.toString()
    var r = 0

    for (i in s.lastIndex downTo 0) {
        if (s[i] == '0') r++ else break
    }

    println(r)
}
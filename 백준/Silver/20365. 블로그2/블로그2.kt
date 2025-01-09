fun main() {
    val N = readln().toInt()
    val str = readln()
    var rn = 1
    var bn = 1

    var prev = 'R'

    for (i in 0 until N) {
        if (prev == str[i]) continue
        prev = str[i]
        if (str[i] == 'R') continue
        rn++
    }

    prev = 'B'

    for (i in 0 until N) {
        if (prev == str[i]) continue
        prev = str[i]
        if (str[i] == 'B') continue
        bn++
    }

    println(minOf(rn, bn))
}
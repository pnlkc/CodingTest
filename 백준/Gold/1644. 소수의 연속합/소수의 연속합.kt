fun main() {
    var count = 0
    val n = readln().toInt()
    val list = mutableListOf<Int>()

    (2..n).forEach { if (check(it)) list.add(it) }

    var s = 0
    var e = 0
    var sum = 2

    while (s <= list.lastIndex) {
        when {
            sum == n -> {
                count++
                sum -= list[s++]
            }
            sum > n -> sum -= list[s++]
            else -> if (e < list.lastIndex) sum += list[++e] else sum -= list[s++]
        }
    }

    println(count)
}

fun check(num: Int): Boolean {
    var i = 2

    while (i * i <= num) {
        if (num % i == 0) return false else i++
    }

    return true
}
fun main() {
    val m = readln().toInt()
    var s = 1
    var e = 500_000_000
    var num = -1

    while (s <= e) {
        val mid = (s + e) / 2
        val cnt = find(mid)

        when {
            cnt >= m -> {
                if (cnt == m) num = mid
                e = mid - 1
            }
            else -> s = mid + 1
        }
    }

    println(num)
}

fun find(num: Int): Int {
    var result = 0
    var pow = 5

    while (pow <= num) {
        result += num / pow
        pow *= 5
    }

    return result
}
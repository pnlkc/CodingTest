import kotlin.math.pow

fun main() {
    val (A, B) = readln().split(" ").map { it.toLong() }
    val list = BooleanArray(10_000_001) { true }
    var cnt = 0
    list[0] = false
    list[1] = false

    for (i in 2..list.lastIndex) {
        if (!list[i]) continue

        var num = 2

        while (i * num <= 10_000_000) {
            list[i * num++] = false
        }
    }

    for (i in list.indices) {
        if (list[i]) {
            var num = 2

            while (i.toDouble().pow(num.toDouble()).toLong() <= B) {
                if (i.toDouble().pow(num.toDouble()).toLong() >= A) cnt++
                num++
            }
        }
    }

    println(cnt)
}
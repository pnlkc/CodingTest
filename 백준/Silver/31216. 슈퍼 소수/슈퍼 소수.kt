import kotlin.math.sqrt

fun main() {
    val T = readln().toInt()
    val list = mutableListOf(2)

    while (list.size < 30_000) {
        p@ for (i in list.last() + 1..1_000_000_000) {
            for (j in 2..sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) continue@p
            }

            list.add(i)
            break
        }
    }

    repeat(T) {
        val n = readln().toInt()

        println(list[list[n - 1] - 1])
    }
}
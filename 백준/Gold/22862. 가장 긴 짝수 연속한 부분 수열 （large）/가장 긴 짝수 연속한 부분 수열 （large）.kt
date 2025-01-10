fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var s = 0
    var e = 0
    var c = 0
    var l = 0
    var max = 0

    while (e in s until N) {
        if (list[e] % 2 == 0) {
            l++
            e++
        } else {
            if (c < K) {
                e++
                c++
            } else {
                if (list[s++] % 2 != 0) c-- else l--
            }
        }

        max = maxOf(max, l)
    }

    println(max)
}
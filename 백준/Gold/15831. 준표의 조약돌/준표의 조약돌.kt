fun main() {
    val (N, B, W) = readln().split(" ").map { it.toInt() }
    val input = readln()

    var s = 0
    var e = 0
    var wc = 0
    var bc = 0
    var max = 0

    while (e < N) {
        if (input[e] == 'W') {
            wc++
            e++
        } else {
            if (bc >= B) {
                if (input[s++] == 'W') wc-- else bc--
                if (s > e) {
                    e = s
                    wc = 0
                    bc = 0
                }
            } else {
                bc++
                e++
            }
        }

        if (wc >= W) max = maxOf(max, wc + bc)
    }

    println(max)
}
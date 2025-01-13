fun main() {
    val (N, L) = readln().split(" ").map { it.toInt() }
    val arr = Array(L) { 0 to 0 }

    for (i in 1..N) {
        val (D, R, G) = readln().split(" ").map { it.toInt() }

        arr[D] = R to G
    }

    var pos = 0
    var time = 0

    while (pos < L) {
        val (r, g) = arr[pos]

        if (r == 0 || g == 0) {
            pos++
            time++
            continue
        }

        if (time % (r + g) in r until r + g) {
            pos++
        }

        time++
    }

    print(time)
}
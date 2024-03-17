fun main() {
    val N = readln().toInt()
    var r = 0
    var s = 1
    var e = 1
    var sum = 1

    while (e in s..N) {
        if (sum > N) {
            sum -= s++

        } else {
            if (sum == N) r++

            sum += ++e
        }
    }

    println(r)
}
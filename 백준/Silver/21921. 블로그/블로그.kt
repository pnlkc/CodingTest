fun main() {
    val (N, X) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var cnt = 1
    var max = list.slice(0 until X).sum()
    var prev = max

    for (i in 1..N - X) {
        prev = prev - list[i - 1] + list[X + i - 1]

        if (prev > max) {
            max = prev
            cnt = 1
        } else if (prev == max) {
            cnt++
        }
    }

    if (max == 0) {
        println("SAD")
    } else {
        println(max)
        print(cnt)
    }
}
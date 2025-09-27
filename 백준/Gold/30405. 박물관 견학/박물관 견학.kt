fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N * 2)
    var idx = 0

    for (i in 0 until N) {
        val list = readln().split(" ").map { it.toInt() }

        arr[idx++] = list[1]
        arr[idx++] = list[list[0]]
    }

    arr.sort()

    println(arr[N - 1])
}
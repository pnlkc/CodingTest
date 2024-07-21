fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val arr = IntArray(1_000_001)
    var cnt = 0

    for (i in 0 until N) {
        if (arr[list[i]] == 0) {
            cnt++
            arr[list[i] - 1]++
        } else {
            arr[list[i]]--
            arr[list[i] - 1]++
        }
    }

    println(cnt)
}
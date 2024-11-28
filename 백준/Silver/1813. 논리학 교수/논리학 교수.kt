fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    var result = 0

    for (i in 0 until N) {
        if (map[arr[i]] == null) map[arr[i]] = 1
        else map[arr[i]] = map[arr[i]]!! + 1
    }

    for ((k, v) in map) {
        if (k == v) result = maxOf(result, k)
    }

    println(if (map[0] != null && result == 0) -1 else result)
}
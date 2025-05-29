fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N)
    var result = 0

    arr[0] = list[0]

    for (i in 1 until N) {
        if (list[i] > list[i - 1]) {
            arr[i] = arr[i - 1]
            result = maxOf(result, list[i] - arr[i])
        } else {
            arr[i] = list[i]
        }
    }

    println(result)
}
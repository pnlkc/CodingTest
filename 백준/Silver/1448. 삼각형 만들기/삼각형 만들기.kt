fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var result = -1

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sortDescending()

    for (i in 0 until N - 2) {
        if (arr[i] < arr[i + 1] + arr[i + 2]) {
            result = arr[i] + arr[i + 1] + arr[i + 2]
            break
        }
    }

    println(result)
}
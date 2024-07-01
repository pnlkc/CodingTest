fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var sum = 0L

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sortDescending()

    for (i in 0 until N) {
        if (arr[i] - i < 0) break
        sum += arr[i] - i
    }

    println(sum)
}
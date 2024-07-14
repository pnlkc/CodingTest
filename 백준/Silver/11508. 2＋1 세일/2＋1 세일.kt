fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var sum = 0L

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sortDescending()

    for (i in 0 until N) {
        if (i % 3 != 2) sum += arr[i]
    }

    println(sum)
}
fun main() {
    val num = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val memo = IntArray(num) { 1 }
    var max = 1

    for (i in 1 until num) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) memo[i] = maxOf(memo[i], memo[j] + 1)
        }
        max = maxOf(max, memo[i])
    }

    println(max)
}
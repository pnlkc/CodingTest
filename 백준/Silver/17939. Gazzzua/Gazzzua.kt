fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var result = 0
    var max = arr.last()
    var cnt = 0
    var sum = 0

    for (i in N - 2 downTo 0) {
        if (arr[i] <= max) {
            cnt++
            sum += arr[i]
        } else {
            result += cnt * max - sum
            cnt = 0
            sum = 0
            max = arr[i]
        }
    }

    result += cnt * max - sum

    println(result)
}

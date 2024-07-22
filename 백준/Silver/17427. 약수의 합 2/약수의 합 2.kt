fun main() {
    val N = readln().toInt()
    val arr = LongArray(N + 1)

    for (i in 1..N) {
        var num = i

        while (num <= N) {
            arr[num] += i.toLong()
            num += i
        }
    }

    println(arr.sum())
}
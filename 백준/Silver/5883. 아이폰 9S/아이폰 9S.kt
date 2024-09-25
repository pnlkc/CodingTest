fun main() {
    val N = readln().toInt()
    val set = mutableSetOf<Int>()
    val arr = IntArray(N)
    var result = 0

    for (i in 0 until N) {
        val num = readln().toInt()
        set.add(num)
        arr[i] = num
    }

    for (num in set) {
        var max = 0
        var prev = 0
        var cLen = 1

        for (i in 0 until N) {
            if (arr[i] == num) continue

            if (prev != arr[i]) {
                max = maxOf(max, cLen)
                prev = arr[i]
                cLen = 1
            } else {
                cLen++
            }
        }

        max = maxOf(max, cLen)
        result = maxOf(result, max)
    }

    println(result)
}
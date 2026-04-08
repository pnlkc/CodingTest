fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    val arr = Array(n + 1) { intArrayOf(Int.MAX_VALUE, 0, Int.MAX_VALUE, 0) }
    val result = LongArray(2)

    repeat(n) {
        val (a, v, h) = readln().split(" ").map { it.toInt() }

        arr[a][0] =  minOf(arr[a][0], v)
        arr[a][1] =  maxOf(arr[a][1], v)
        arr[a][2] =  minOf(arr[a][2], h)
        arr[a][3] =  maxOf(arr[a][3], h)

        if (arr[a][0] != Int.MAX_VALUE && arr[a][2] != Int.MAX_VALUE && arr[a][1] != 0 && arr[a][3] != 0) {
            val diffY = arr[a][1] - arr[a][0] + 1
            val diffX = arr[a][3] - arr[a][2] + 1
            val num = diffY.toLong() * diffX

            if (result[1] < num) {
                result[0] = a.toLong()
                result[1] = num
            } else if (result[1] == num) {
                result[0] = minOf(result[0], a.toLong())
            }
        }
    }

    println(result.joinToString(" "))
}
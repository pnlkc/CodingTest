fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    repeat(T) {
        val N = readln().toInt()
        var arr = readln().split(" ").map { it.toInt() }.toIntArray()
        var day = 1

        while (check(arr, N)) {
            day++

            val temp = IntArray(6)

            for (i in 0 until 6) {
                temp[i] = arr[i] + arr[(5 + i) % 6] + arr[(i + 1) % 6] + arr[(i + 3) % 6]
            }

            arr = temp
        }

        sb.appendLine(day)
    }

    print(sb)
}

fun check(arr: IntArray, num: Int): Boolean {
    var sum = 0

    for (i in 0 until 6) {
        sum += arr[i]

        if (sum > num) return false
    }

    return true
}
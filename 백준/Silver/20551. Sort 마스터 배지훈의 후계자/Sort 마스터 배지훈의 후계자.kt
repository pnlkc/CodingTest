fun main() {
    val sb = StringBuilder()
    val (A, N) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(A)

    for (i in 0 until A) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    repeat (N) {
        val num = readln().toInt()
        var s = 0
        var e = A - 1
        var idx = -1

        while (s <= e) {
            val mid = (s + e) / 2

            when {
                arr[mid] > num -> e = mid - 1
                arr[mid] < num -> s = mid + 1
                arr[mid] == num -> {
                    idx = mid
                    e = mid - 1
                }
            }
        }

        sb.appendLine(idx)
    }

    print(sb)
}
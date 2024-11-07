fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val x = N * 4 - 3
    val y = N * 2 - 1
    val arr = Array(y) { CharArray(x) { ' ' } }

    for (i in 0 until N) {
        if (i == 0) {
            for (j in 0 until N) {
                arr[0][0 + j] = '*'
                arr[0][x - 1 - j] = '*'
                arr[y - 1][0 + j] = '*'
                arr[y - 1][x - 1 - j] = '*'
            }
        } else {
            arr[i][i] = '*'
            arr[i][i + N - 1] = '*'
            arr[i][x - 1 - i] = '*'
            arr[i][x - i - N] = '*'
            arr[y - 1 - i][i] = '*'
            arr[y - 1 - i][i + N - 1] = '*'
            arr[y - 1 - i][x - 1 - i] = '*'
            arr[y - 1 - i][x - i - N] = '*'
        }
    }

    for (i in 0 until N * 2 - 1) {
        sb.appendLine(arr[i].joinToString("").trimEnd())
    }

    print(sb)
}
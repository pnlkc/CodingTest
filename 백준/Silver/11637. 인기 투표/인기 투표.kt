fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val n = readln().toInt()
        var arr = IntArray(n)
        var sum = 0
        var max = 0
        var maxIdx = -1
        var isDuplicate = false

        for (i in 0 until n) {
            arr[i] = readln().toInt()
            sum += arr[i]
        }

        for (i in 0 until n) {
            if (max < arr[i]) {
                isDuplicate = false
                max = arr[i]
                maxIdx = i + 1
            } else if (max == arr[i]) {
                isDuplicate = true
            }
        }

        if (isDuplicate) {
            sb.appendLine("no winner")
        } else if (sum < arr[maxIdx - 1] * 2)  {
            sb.appendLine("majority winner $maxIdx")
        } else {
            sb.appendLine("minority winner $maxIdx")
        }
    }

    print(sb)
}
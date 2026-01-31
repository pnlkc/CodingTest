fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val cArr = IntArray(10)
    var result = 0
    var l = 0
    var r = 0
    var cnt = 0

    while (l < n && r < n) {
        if (cnt > 2) {
            while (l < n && cnt > 2) {
                if (--cArr[arr[l++]] == 0) cnt--
            }
        } else {
            while (r < n && cnt <= 2) {
                if (++cArr[arr[r++]] == 1) cnt++
                if (cnt <= 2) result = maxOf(result, r - l)
            }
        }
    }

    println(result)
}
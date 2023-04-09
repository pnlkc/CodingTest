fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(k) { readln().toInt() }.also { it.sort() }
    var s = 1L
    var e = arr.last().toLong()
    
    p@while (s <= e) {
        var count = 0L
        val mid = (s + e) / 2

        for (i in 0 until k) {
            count += arr[i] / mid
            if (count >= n) {
                s = mid + 1
                continue@p
            }
        }

        e = mid - 1
    }

    println(e)
}
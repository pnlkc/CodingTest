data class Data(val pos: Int, val color: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { Data(-1, -1) }
    var result = 0L

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        arr[i] = Data(x, y)
    }

    arr.sortWith { d1, d2 -> d1.pos - d2.pos }

    for (i in 0 until N) {
        var l = i - 1
        var r = i + 1
        var dist = Int.MAX_VALUE

        while (l >= 0) {
            if (arr[l].color == arr[i].color) {
                dist = minOf(dist, arr[i].pos - arr[l].pos)
                break
            }

            l--
        }

        while (r < N) {
            if (arr[r].color == arr[i].color) {
                dist = minOf(dist, arr[r].pos - arr[i].pos)
                break
            }

            r++
        }

        result += dist
    }

    println(result)
}
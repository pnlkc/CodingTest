data class Pos(val x: Int, val y: Int)

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val paperCnt = readln().toInt()
    val spaceCnt = readln().toInt()
    val spaceArr = Array(spaceCnt) { Pos(0, 0) }
    var minY = 0
    var answer = Int.MAX_VALUE

    for (i in 0 until spaceCnt) {
        val (y, x) = readln().split(" ").map { it.toInt() }

        spaceArr[i] = Pos(x, y)
        minY = maxOf(minY, y)
    }

    spaceArr.sortBy { it.x }

    var s = 1
    var e = maxOf(c, r)

    while (s <= e) {
        val mid = (s + e) / 2

        var idx = 0
        var cnt = 0

        for (i in 0 until spaceCnt) {
            if (spaceArr[i].x > idx) {
                cnt++
                idx = spaceArr[i].x + mid - 1
            }
        }

        if (cnt <= paperCnt) {
            e = mid - 1
            answer = minOf(mid, answer)
        } else {
            s = mid + 1
        }
    }

    println(if (answer < minY) minY else answer)
}
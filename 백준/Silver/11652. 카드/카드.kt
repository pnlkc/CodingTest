fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<Long, Int>()
    var maxCnt = 0
    var result = 0L

    (1..N).forEach {
        val num = readln().toLong()
        if (map[num] == null) {
            map[num] = 1

            if (map[num]!! > maxCnt) {
                maxCnt = map[num]!!
                result = num
            } else if (map[num]!! == maxCnt && num < result) {
                result = num
            }
        } else {
            map[num] = map[num]!! + 1

            if (map[num]!! > maxCnt) {
                maxCnt = map[num]!!
                result = num
            } else if (map[num]!! == maxCnt && num < result) {
                result = num
            }
        }
    }

    println(result)
}
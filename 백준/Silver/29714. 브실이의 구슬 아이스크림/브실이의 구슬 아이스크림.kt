import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val cL = br.readLine().split(" ").map { it.toInt() }
    val Q = br.readLine().toInt()
    val map = mutableMapOf<Int, Long>()

    for (i in 0 until N) {
        map[cL[i]] = map.getOrDefault(cL[i], 0) + 1
    }

    repeat(Q) {
        val aL = br.readLine().split(" ").map { it.toInt() }
        val bL = br.readLine().split(" ").map { it.toInt() }
        val checkMap = mutableMapOf<Int, Long>()
        var canApply = true

        for (i in 1..aL[0]) {
            checkMap[aL[i]] = checkMap.getOrDefault(aL[i], 0L) + 1
        }

        for ((key, count) in checkMap) {
            if (map.getOrDefault(key, 0L) < count) {
                canApply = false
                break
            }
        }

        if (canApply) {
            for ((key, count) in checkMap) {
                map[key] = map[key]!! - count
                if (map[key] == 0L) map.remove(key)
            }
            for (i in 1..bL[0]) {
                map[bL[i]] = map.getOrDefault(bL[i], 0L) + 1
            }
        }
    }

    println(map.values.sum())

    val result = map
        .map {
            val sb = StringBuilder()

            for (i in 0 until it.value) {
                if (i != 0L) sb.append(" ")
                sb.append(it.key)
            }

            sb.toString()
        }
        .filter { it.isNotEmpty() }
        .joinToString(" ")

    if (result.isNotEmpty()) println(result)
}
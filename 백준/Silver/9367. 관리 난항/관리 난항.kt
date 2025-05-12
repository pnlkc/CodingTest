import kotlin.math.ceil

data class Data(val p: Int, val q: Int, val k: Int)

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val dataMap = mutableMapOf<String, Data>()
        val resultMap = mutableMapOf<String, Pair<String, Int>>()

        for (i in 1..n) {
            val (str, p, q, k) = readln().split(" ")

            dataMap[str] = Data(p.toInt(), q.toInt(), k.toInt())
        }

        for (i in 1..m) {
            val (t, s, e, a) = readln().split(" ")

            when (e) {
                "p" -> {
                    if (resultMap[s] == null) {
                        resultMap[s] = a to if (dataMap[a] == null) -1 else dataMap[a]!!.q
                    } else {
                        if (resultMap[s]!!.first.isEmpty() && resultMap[s]!!.second != -1) {
                            resultMap[s] = a to if (dataMap[a] == null) -1 else resultMap[s]!!.second + dataMap[a]!!.q
                        } else {
                            resultMap[s] = "" to -1
                        }
                    }
                }
                "r" -> {
                    if (resultMap[s] == null || resultMap[s]!!.first.isEmpty()) {
                        resultMap[s] = "" to -1
                    } else if (resultMap[s]!!.first.isNotEmpty() && resultMap[s]!!.second != -1) {
                        resultMap[s] = "" to resultMap[s]!!.second + dataMap[resultMap[s]!!.first]!!.k * a.toInt()
                    }
                }
                "a" -> {
                    if (resultMap[s] == null || resultMap[s]!!.first.isEmpty()) {
                        resultMap[s] = "" to -1
                    } else if (resultMap[s]!!.first.isNotEmpty() && resultMap[s]!!.second != -1) {
                        resultMap[s] = resultMap[s]!!.first to resultMap[s]!!.second + ceil(dataMap[resultMap[s]!!.first]!!.p.toDouble() * a.toInt() / 100).toInt()
                    }
                }
            }
        }

        resultMap.keys.sorted().forEach {
            sb.appendLine("$it ${if (resultMap[it]!!.first.isNotEmpty() || resultMap[it]!!.second == -1) "INCONSISTENT" else resultMap[it]!!.second}")
        }
    }

    print(sb)
}
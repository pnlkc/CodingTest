fun main() {
    val (N, C) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    
    if (list.contains(C)) {
        println(1)
        return
    }

    var s = 0
    var e = N - 1

    while (s < e) {
        val sum = list[s] + list[e]

        when {
            sum == C -> {
                println(1)
                return
            }
            sum > C -> {
                e--
            }
            else -> {
                val idx = list.indexOf(C - sum)

                if (idx != -1 && idx != s && idx != e) {
                    println(1)
                    return
                }

                s++
            }
        }
    }

    println(0)
}
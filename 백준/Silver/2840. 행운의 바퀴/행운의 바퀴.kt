fun main() {
    val sb = StringBuilder()
    val (N, K) = readln().split(" ").map { it.toInt() }
    val result = Array(N) { "?" }

    var idx = 0

    for (i in 1..K) {
        val (S, C) = readln().split(" ")

        idx = (idx - S.toInt())

        while (idx < 0) {
            idx += N
        }

        idx %= N

        if (result[idx] != "?" && result[idx] != C) {
            idx = -1
            break
        }

        result[idx] = C
    }

    val cnt = mutableMapOf<String, Boolean>()

    for (i in 0 until N) {
        if (result[i] != "?") {
            if (cnt[result[i]] != null) {
                println("!")
                return
            } else {
                cnt[result[i]] = true
            }
        }
    }

    if (idx == -1) {
        println("!")
        return
    }

    for (i in idx until N) {
        sb.append(result[i])
    }

    for (i in 0 until idx) {
        sb.append(result[i])
    }

    println(sb)
}
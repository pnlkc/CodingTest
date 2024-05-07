fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val input = readln()
    val canEat = BooleanArray(N)
    var cnt = 0

    for (i in 0 until N) {
        if (input[i] == 'H') canEat[i] = true
    }

    p@ for (i in 0 until N) {
        if (input[i] == 'H') continue

        for (j in (i - K)..(i + K)) {
            if (j < 0 || j >= N) continue

            if (canEat[j]) {
                canEat[j] = false
                cnt++
                continue@p
            }
        }
    }

    println(cnt)
}
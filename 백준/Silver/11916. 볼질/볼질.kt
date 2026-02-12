fun main() {
    val n = readln().toInt()
    val list = readln().trim().split(" ").map { it.toInt() }
    val status = BooleanArray(4)
    var result = 0
    var cnt = 0

    for (i in 0 until n) {
        when (list[i]) {
            1 -> cnt++
            3 -> {
                if (status[3]) {
                    status[3] = false
                    result++
                }

                status[3] = status[2]
                status[2] = status[1]
                status[1] = false
                cnt++
            }
        }

        if (list[i] == 2 || cnt == 4) {
            if (status[3] && status[2] && status[1]) result++
            if (status[2] && status[1]) status[3] = true
            if (status[1]) status[2] = true

            status[1] = true
            cnt = 0
        }
    }

    println(result)
}
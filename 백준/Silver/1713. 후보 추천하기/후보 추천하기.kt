fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val status = IntArray(n + 1)
    val nArr = IntArray(n + 1)
    val cnt = IntArray(101)
    var l = 0

    p@ for (i in 0 until m) {
        val num = list[i]
        val idx = status.indexOf(num)

        if (idx != -1) {
            status[idx]
            cnt[num]++
        } else {
            for (j in 1..n) {
                if (status[j] == 0) {
                    status[j] = num
                    nArr[j] = ++l
                    cnt[num] = 1
                    continue@p
                }
            }

            var min = Int.MAX_VALUE
            var idx = 0

            for (j in 1..n) {
                if (cnt[status[j]] < min) {
                    idx = j
                    min = cnt[status[j]]
                } else if (cnt[status[j]] == min) {
                    if (nArr[idx] > nArr[j]) idx = j
                }
            }

            cnt[status[idx]] = 0
            status[idx] = num
            nArr[idx] = ++l
            cnt[num] = 1
        }
    }

    println(status.filter { it != 0 }.sorted().joinToString(" "))
}
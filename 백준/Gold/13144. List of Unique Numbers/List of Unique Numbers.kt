fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var s = 0
    var e = 0
    val isExist = BooleanArray(100_001)
    var result = 0L
    isExist[list[0]] = true

    while (s < N) {
        if (e + 1 < N && !isExist[list[e + 1]]) {
            isExist[list[++e]] = true
        } else {
            result += e - s + 1
            isExist[list[s++]] = false
        }
    }

    println(result)
}
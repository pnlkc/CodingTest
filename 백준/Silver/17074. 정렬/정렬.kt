fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var cnt = 0
    var idx = 0
    var result = 0

    for (i in 1 until N) {
        if (list[i - 1] > list[i]) {
            cnt++
            idx = i
        }
    }
    println(
        when (cnt) {
            0 -> N
            1 -> {
                // idx를 제거하면 되는 경우
                if (idx == N - 1 || list[idx - 1] <= list[idx + 1]) result++

                // idx - 1을 제거하면 되는 경우
                if(idx == 1 || list[idx - 2] <= list[idx]) result++

                result
            }
            else -> 0
        }
    )
}
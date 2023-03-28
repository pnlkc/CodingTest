fun main() {
    val tcNum = readln().toInt()
    val arr = Array(tcNum) { readln().split(" ").map { it.toInt() } }
    val memo = IntArray(tcNum) { 1 }
    var max = 0

    // 왼쪽 기둥 번호를 기준으로 오름차순 정렬
    arr.sortBy { it[0] }

    for (i in 1 until tcNum) {
        for (j in 0 until i) {
            if (arr[i][1] > arr[j][1]) memo[i] = maxOf(memo[i], memo[j] + 1)
        }
        max = maxOf(max, memo[i])
    }

    println(tcNum - max)
}
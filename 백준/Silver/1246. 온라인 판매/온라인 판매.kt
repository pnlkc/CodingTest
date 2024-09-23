fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val pList = IntArray(M)
    var max = 0
    var maxP = 0

    for (i in 0 until M) {
        pList[i] = readln().toInt()
    }

    pList.sort()

    for (idx in 0 until M) {
        if (max < pList[idx] * minOf(N, M - idx)) {
            maxP = pList[idx]
            max = pList[idx] * minOf(N, M - idx)
        }
    }

    println("$maxP $max")
}
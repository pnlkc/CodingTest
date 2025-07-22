fun main() {
    val N = readln().toInt()
    val vL = readln().split(" ").map { it.toInt() }
    var sum = 0L
    var cur = 0

    for (i in N - 1 downTo 0) {
        when {
            vL[i] > cur -> sum += ++cur
            vL[i] == cur -> sum += cur
            vL[i] < cur -> {
                sum += vL[i]
                cur = vL[i]
            }
        }
    }

    println(sum)
}
fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    for (i in 0 until M) {
        val k = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }

        for (i in 0 until k - 1) {
            if (list[i] < list[i + 1]) {
                println("No")
                return
            }
        }
    }

    println("Yes")
}
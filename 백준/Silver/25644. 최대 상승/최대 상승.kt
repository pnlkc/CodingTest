fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var result = 0
    var max = list.last()

    for (i in N - 1 downTo 0) {
        if (list[i] > max) {
            max = list[i]
        } else {
            result = maxOf(result, max - list[i])
        }
    }

    println(result)
}
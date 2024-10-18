val list = mutableListOf<String>()

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    calc("1", 1, n, k)
    calc("2", 2, n, k)
    calc("3", 3, n, k)

    println(if (list.size < k) -1 else list[k - 1])
}

fun calc(str: String, sum: Int, n: Int, k: Int) {
    if (sum > n) return
    if (list.size > k)  return

    if (sum == n) {
        list.add(str)
        return
    }

    calc("$str+1", sum + 1, n, k)
    calc("$str+2", sum + 2, n, k)
    calc("$str+3", sum + 3, n, k)
}
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()

    for (i in n downTo 1) {
        val cnt = list.count { it >= i }
        val num = if (cnt == n) 0 else list[n - cnt - 1]

        if (cnt >= i && num <= i) {
            println(i)
            return
        }
    }
    
    println(0)
}
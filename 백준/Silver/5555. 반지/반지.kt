fun main() {
    val str = readln()
    val N = readln().toInt()
    var cnt = 0

    for (tc in 1..N) {
        val input = readln()
        val temp = input + input

        if (temp.contains(str)) cnt++
    }

    println(cnt)
}
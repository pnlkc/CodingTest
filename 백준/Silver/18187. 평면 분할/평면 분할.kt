fun main() {
    val N = readln().toInt()
    var result = 2
    var num = 2

    for (i in 2..N) {
        result += num

        if (i % 3 != 0) num++
    }

    println(result)
}
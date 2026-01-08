fun main() {
    val n = readln().toInt()
    var num = 1L

    while ((num + 1) * (num + 1) < n) {
        num++
    }

    println(num)
}
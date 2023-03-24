fun main() {
    val n = readln().toInt()
    var num = 1
    while (n >= (num + 1) * (num + 1)) {
        num++
    }
    println(num)
}
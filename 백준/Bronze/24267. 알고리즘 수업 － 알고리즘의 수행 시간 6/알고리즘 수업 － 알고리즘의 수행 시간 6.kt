fun main() {
    val input = readln().toLong()
    var sum = 0L
    var num = input - 2
    for (i in 1..num) {
        sum += i * num
        num--
    }
    println(sum)
    println(3)
}
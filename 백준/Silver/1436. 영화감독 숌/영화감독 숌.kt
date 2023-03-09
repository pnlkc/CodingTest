fun main() {
    var (target, num, count) = intArrayOf(readln().toInt(), 0, 0)
    while (count != target) {
        num++
        if (num.toString().contains("666")) count++
    }
    println(num)
}
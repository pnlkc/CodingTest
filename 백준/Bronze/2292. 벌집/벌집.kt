fun main() {
    var answer = 1
    val target = readln().toInt()
    var num = 1
    var start = 6

    while (target > num) {
        answer++
        num += start
        start += 6
    }

    println(answer)
}
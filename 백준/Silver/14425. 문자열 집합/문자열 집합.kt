fun main() {
    var answer = 0
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nMap = mutableMapOf<String, Boolean>()
    repeat(n) {
        nMap[readln()] = true
    }
    repeat(m) {
        if (nMap[readln()] == true) answer++
    }
    println(answer)
}
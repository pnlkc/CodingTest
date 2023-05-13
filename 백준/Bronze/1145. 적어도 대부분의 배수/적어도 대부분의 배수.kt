fun main() {
    val list = readln().split(' ').map(String::toInt)
    for (i in 1..1_000_000) {
        var count = 0
        list.forEach { if (i % it == 0) count++ }
        if (count >= 3) return println(i)
    }
}
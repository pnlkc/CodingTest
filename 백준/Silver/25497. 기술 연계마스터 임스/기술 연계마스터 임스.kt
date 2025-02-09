fun main() {
    val N = readln().toInt()
    val input = readln()
    val map = mutableMapOf('L' to 0, 'S' to 0)
    var cnt = 0

    for (c in input) {
        when (c) {
            'L' -> map['L'] = map['L']!! + 1
            'R' -> {
                if (map['L']!! <= 0) break
                map['L'] = map['L']!! - 1
                cnt++
            }
            'S' -> map['S'] = map['S']!! + 1
            'K' -> {
                if (map['S']!! <= 0) break
                map['S'] = map['S']!! - 1
                cnt++
            }
            else -> cnt++
        }
    }

    println(cnt)
}
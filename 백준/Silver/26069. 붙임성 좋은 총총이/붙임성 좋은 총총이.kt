fun main() {
    val map = mutableMapOf("ChongChong" to true)
    var count = 1

    repeat(readln().toInt()) {
        val (p1, p2) = readln().split(" ")
        if (map[p1] == true && map[p2] != true) {
            map[p2] = true
            count++
        } else if (map[p2] == true && map[p1] != true) {
            map[p1] = true
            count++
        }
    }
    
    println(count)
}
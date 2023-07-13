fun main() {
    val n = readln().toInt()
    val list = readln().split(' ').map(String::toInt)
    var y = 0
    var m = 0
    
    for (i in 0 until n) {
        val t = list[i]
        y += t /30 * 10
        if (t % 30 >= 0) y += 10
        m += t / 60 * 15
        if (t % 60 >= 0) m += 15
    }
    
    println(
        when {
            y == m -> "Y M " + y
            y > m -> "M " + m
            else -> "Y " + y
        }
    )
}
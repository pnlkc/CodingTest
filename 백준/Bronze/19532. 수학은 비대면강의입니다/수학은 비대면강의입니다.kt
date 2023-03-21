fun main() {
    val l = readln().split(" ").map { it.toInt() }
    var y = 0
    var x = 0
    
    when {
        l[0] == 0 -> {
            y = l[2] / l[1]
            x = (l[5] - (l[4] * y)) / l[3]
        }
        l[1] == 0 -> {
            x = l[2] / l[0]
            y = (l[5] - (l[3] * x)) / l[4]
        }
        l[3] == 0 -> {
            y = l[5] / l[4]
            x = (l[2] - (l[1] * y)) / l[0]
        }
        l[4] == 0 -> {
            x = l[5] / l[3]
            y = (l[2] - (l[0] * x)) / l[1]
        }
        else -> {
            y = if ((l[0] * l[4] - l[1] * l[3]) == 0) 0 else (l[0] * l[5] - l[2] * l[3]) / (l[0] * l[4] - l[1] * l[3])
            x = (-l[1] * y + l[2]) / l[0]
        }
    }
    
    println("$x $y")
}
fun main() {
    val N = readln().toInt()
    val fL = readln().split(" ").map { it.toInt() }.toMutableList()
    val sL = readln().split(" ").map { it.toInt() }.toMutableList()
    var max = 0
    var min = 0

    for (i in 0 until N) {
        max += if (fL[i] < 0) fL[i] * -1 else fL[i]
        min += if (sL[i] < 0) sL[i] else sL[i] * -1
    }
    
    println(max - min)
}
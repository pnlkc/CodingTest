fun main() {
    val (a, b) = readLine()!!.trim().split(" ").map { it.toInt() }
    
    println(b / a)
}
fun main() {
    val k = readLine()!!.trim().toInt()

    println(
        when (k % 5) {
            1 -> 'g'
            4 -> 'r'
            0 -> 'm'
            else -> 'o'
        }
    )
}
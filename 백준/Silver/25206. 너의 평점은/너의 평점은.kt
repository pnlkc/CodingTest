fun main() {
    val map = mutableMapOf(
        "A+" to 4.5, "A0" to 4.0, "B+" to 3.5, "B0" to 3.0, "C+" to 2.5, "C0" to 2.0, "D+" to 1.5,
        "D0" to 1.0, "F" to 0.0
    )
    var sum1 = 0.0
    var sum2 = 0.0
    
    repeat(20) {
        val (name, num1, num2) = readln().split(" ")
        if (num2 != "P") {
            sum1 += num1.toDouble()
            sum2 += num1.toDouble() * map[num2]!!
        }
    }

    println(sum2 / sum1)
}
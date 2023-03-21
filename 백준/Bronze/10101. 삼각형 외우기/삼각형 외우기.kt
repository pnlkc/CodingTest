fun main() {
    var sum = 0
    val set = mutableSetOf<Int>()
    repeat(3) {
        set.add(readln().toInt().also { sum += it })
    }
    
    println(
        when {
            sum != 180 -> "Error"
            set.size == 1 -> "Equilateral"
            set.size == 2 -> "Isosceles"
            else -> "Scalene"
        }
    )
}
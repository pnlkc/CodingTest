fun main() {
    val input = readln().toInt()
    var array = intArrayOf(1, 0)
    
    repeat(input) {
        val num = array.sum()
        array[0] = array[1]
        array[1] = num
    }
    
    println(array[1])
}
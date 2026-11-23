fun main() {
    var result = readln().toInt()
    
    repeat(9) {
        result -= readln().toInt()
    }
    
    println(result)
}
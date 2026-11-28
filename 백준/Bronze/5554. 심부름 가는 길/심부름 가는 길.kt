fun main() {
    var result = 0
    
    repeat(4) {
       result += readln().toInt() 
    }
    
    println(result / 60)
    println(result % 60)
}
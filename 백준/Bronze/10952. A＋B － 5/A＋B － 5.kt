fun main() {
    var input = readln()
    
    while (input != "0 0") {
        println(input.split(" ").sumOf { it.toInt() })
        input = readln()
    }
}
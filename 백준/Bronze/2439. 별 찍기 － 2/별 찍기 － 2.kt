fun main() {
    var num = readln().toInt()
    var string = CharArray(num) { ' ' }
    
    for (i in num - 1 downTo 0) {
        string[i] = '*'
        println(string.joinToString(""))
    }
}
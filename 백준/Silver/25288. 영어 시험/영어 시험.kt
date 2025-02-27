fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val str = readln()
    
    repeat(N) {
        sb.append(str)
    }

    println(sb)
}
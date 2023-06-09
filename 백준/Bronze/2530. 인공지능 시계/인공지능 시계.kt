fun main() {
    val (h, m, s) = readln().split(' ').map(String::toInt)
    val sum = h * 3600 + m * 60 + s + readln().toInt()
    
    println("${sum / 3600 % 24} ${sum % 3600 / 60} ${sum % 60}")
}
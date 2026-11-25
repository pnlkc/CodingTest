fun main() {
    val L = readln().toInt()
    val A = readln().toInt()
    val B = readln().toInt()
    val C = readln().toInt()
    val D = readln().toInt()
    
    println(L - maxOf(A / C + if (A % C != 0) 1 else 0, B / D + if (B % D != 0) 1 else 0))
}
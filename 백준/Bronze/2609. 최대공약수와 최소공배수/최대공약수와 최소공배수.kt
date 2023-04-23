fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    calc(a, b).also { 
        println(it)
        println(it * (a / it) * (b / it))
    }
}

fun calc(a: Int, b: Int): Int = if (b == 0) a else calc(b, a % b)
fun main() {
    var N = readln().toLong()
    
    if (N == 0L) {
        println("NO")
        return
    }
    
    var num = 1L

    while (num < N) {
        num *= 3
    }

    while (num > 0) {
        if (num <= N) N -= num
        num /= 3
    }

    println(if (N == 0L) "YES" else "NO")
}
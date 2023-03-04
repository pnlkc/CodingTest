fun main() {
    var num = readln().toInt()
    while (num != 1) {
        for (i in 2..num) {
            if (num % i == 0) {
                num /= i
                println(i)
                break
            }
        }
    }
}
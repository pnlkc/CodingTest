fun main() {
    val N = readln().toInt()
    var num = N
    var cnt = 0

    while (num > 0) {
        if (num.toString().contains("1")) {
            val newNum = num.toString().replaceFirst("1", "").trimStart { it == '0' }
            num = if (newNum.isEmpty()) 0 else newNum.toInt()
        } else {
            num--
        }

        cnt++
    }

    println(cnt)
}
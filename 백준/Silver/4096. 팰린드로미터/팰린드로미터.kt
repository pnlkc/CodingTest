fun main() {
    while (true) {
        val n = readln()

        if (n == "0") return

        val len = n.length
        var num = n.toInt()
        var cnt = 0

        while (true) {
            val str = num.toString().padStart(len, '0')

            if (check(str)) {
                println(cnt)
                break
            }

            num++
            cnt++
        }
    }
}

fun check(str: String): Boolean {
    var l = 0
    var r = str.length - 1

    while (l < r) {
        if (str[l] != str[r]) return false

        l++
        r--
    }

    return true
}
fun main() {
    val name = readln()
    val cnt = IntArray(26)

    for (c in name) {
        cnt[c - 'A']++
    }

    val odd = cnt.count { it % 2 != 0 }

    if (odd >= 2) {
        println("I'm Sorry Hansoo")
        return
    }

    var str = ""
    var char = ' '

    for (i in 0 until 26) {
        if (cnt[i] % 2 != 0) {
            char = 'A' + i
        }

        repeat(cnt[i] / 2) {
            str += 'A' + i
        }
    }

    println("$str${if (char != ' ') char else ""}${str.reversed()}")
}
fun main() {
    val sb = StringBuilder()
    val mapOne = mutableMapOf(
        "063" to 0, "010" to 1, "093" to 2, "079" to 3, "106" to 4,
        "103" to 5, "119" to 6, "011" to 7, "127" to 8, "107" to 9
    )
    val mapTwo = mutableMapOf(
        0 to "063", 1 to "010", 2 to "093", 3 to "079", 4 to "106",
        5 to "103", 6 to "119", 7 to "011", 8 to "127", 9 to "107"
    )

    while (true) {
        val str = readln()

        if (str == "BYE") break

        val split = str.split("+", "=")
        val a = split[0]
        var aNum = ""
        val b = split[1]
        var bNum = ""

        for (i in a.indices step 3) {
            aNum += mapOne[a.substring(i, i + 3)]
        }

        for (i in b.indices step 3) {
            bNum += mapOne[b.substring(i, i + 3)]
        }

        var sum = aNum.toInt() + bNum.toInt()
        var result = ""

        while (sum > 0) {
            result = mapTwo[sum % 10] + result
            sum /= 10
        }

        sb.appendLine("$a+$b=$result")
    }

    print(sb)
}
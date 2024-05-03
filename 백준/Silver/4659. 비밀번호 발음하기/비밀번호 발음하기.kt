fun main() {
    val sb = StringBuilder()
    val vowels = listOf('a', 'e', 'i', 'o', 'u')

    while (true) {
        val input = readln()

        if (input == "end") break

        var can = true
        var hasVowel = false
        var prev = ' '
        var prevType = 0 to 0

        for (c in input) {
            if (vowels.contains(c)) {
                hasVowel = true
            }

            if (vowels.contains(c)) {
                if (prevType.first == 1) {
                    prevType = 1 to (prevType.second + 1)
                    if (prevType.second == 3) {
                        can = false
                        break
                    }
                } else {
                    prevType = 1 to 1
                }
            } else {
                if (prevType.first == 2) {
                    prevType = 2 to (prevType.second + 1)
                    if (prevType.second == 3) {
                        can = false
                        break
                    }
                } else {
                    prevType = 2 to 1
                }
            }

            if (prev == c && c != 'e' && c != 'o') {
                can = false
                break
            }

            prev = c
        }

        if (!hasVowel || !can) {
            sb.appendLine("<${input}> is not acceptable.")
            continue
        }

        sb.appendLine("<${input}> is acceptable.")
    }

    print(sb)
}
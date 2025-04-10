fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val S = readln()
  
        if (S.reversed().startsWith(S)) {
            sb.appendLine(S)
        } else {
            for (i in S.indices) {
                val temp = S + S.slice(0..i).reversed()

                if (temp.reversed().startsWith(S)) {
                    sb.appendLine(temp)
                    break
                }
            }
        }
    }

    print(sb)
}
fun main() {
    val sb = StringBuilder()

    while (true) {
        val (A, B) = readln().split(" ").map { it.toLong() }

        if (A == 0L && B == 0L) break

        val aL = mutableListOf(A)
        val bL = mutableListOf(B)

        while (aL.last() != 1L) {
            if (aL.last() % 2 == 0L) aL.add(aL.last() / 2)
            else aL.add(aL.last() * 3 + 1)
        }

        while (bL.last() != 1L) {
            if (bL.last() % 2 == 0L) bL.add(bL.last() / 2)
            else bL.add(bL.last() * 3 + 1)
        }

        p@ for (i in aL.indices) {
            for (j in bL.indices) {
                if (aL[i] == bL[j]) {
                    sb.appendLine("$A needs $i steps, $B needs $j steps, they meet at ${aL[i]}")
                    break@p
                }
            }
        }
    }

    print(sb)
}
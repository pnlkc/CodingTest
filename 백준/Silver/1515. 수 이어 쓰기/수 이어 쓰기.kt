fun main() {
    val N = readln()
    var nIdx = 0
    var num = 1
    var numIdx = 0

    while (nIdx <= N.lastIndex) {
        val numStr = num.toString()

        while (numIdx <= numStr.lastIndex) {
            if (numStr[numIdx] == N[nIdx]) {
                if (++nIdx > N.lastIndex) break
            }
            
            numIdx++
        }

        if (numIdx > numStr.lastIndex) {
            num++
            numIdx = 0
        }
    }

    println(num)
}
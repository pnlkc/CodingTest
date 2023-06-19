import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        val st = StringTokenizer(readln())
        val map = mutableMapOf(
            "ESTJ" to 0, "ISTJ" to 0, "ENTJ" to 0, "INTJ" to 0,
            "ESFJ" to 0, "ISFJ" to 0, "ESTP" to 0, "ISTP" to 0,
            "ENFJ" to 0, "INFJ" to 0, "ENTP" to 0, "INTP" to 0,
            "ESFP" to 0, "ISFP" to 0, "ENFP" to 0, "INFP" to 0,
        )

        repeat(n) {
            val nt = st.nextToken()
            map[nt] = minOf(3, map[nt]!! + 1)
        }

        val mL = mutableListOf<String>()
        map.forEach { mbti ->
            repeat(mbti.value) {
                mL.add(mbti.key)
            }
        }
        var min = Int.MAX_VALUE

        for (i in 0..mL.lastIndex - 2) {
            for (j in i + 1 until mL.lastIndex) {
                for (k in j + 1..mL.lastIndex) {
                    min = minOf(min, calc(mL[i], mL[j]) + calc(mL[i], mL[k]) + calc(mL[j], mL[k]))
                }
            }
        }

        sb.appendLine(min)
    }

    println(sb)
}

fun calc(a: String, b:String): Int {
    var r = 0
    for (i in 0..3) {
        if (a[i] != b[i]) r++
    }
    return r
}
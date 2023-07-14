fun main() {
    val n = readln().toInt()
    val s = readln()
    var count = 0
    var isFirstL = true
    var used = booleanArrayOf(true, true)
    
    for (i in s.indices) {
        used[0] = used[1]
        used[1] = true
        when {
            isFirstL && s[i] == 'L' -> {
                isFirstL = false
                 if (used[0]) {
                    used[0] = false
                    count++
                }
                used[1] = false
            }
            s[i] == 'L' -> {
                isFirstL = true
                used[1] = false
                count++
            }
            else -> {
                if (used[0]) {
                    used[0] = false
                    count++
                } else if (used[1]) {
                    used[1] = false
                    count++
                }
            }
        }
    }
    
    println(count)
}
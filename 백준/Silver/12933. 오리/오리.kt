fun main() {
    val sound = readln().toCharArray()
    val cArr = charArrayOf('q', 'u', 'a', 'c', 'k')
    var cnt = 0

    while (true) {
        var isChange = false
        var idx = 0

        for (i in sound.indices) {
            if (sound[i] == cArr[idx]) {
                idx = (idx + 1) % 5
                isChange = true
                sound[i] = ' '
            }
        }

        if (isChange && idx == 0) {
            cnt++
        } else if (idx != 0) {
            println(-1)
            return
        } else {
            break
        }
    }

    println(if (sound.count { it == ' ' } != sound.size) -1 else cnt)
}
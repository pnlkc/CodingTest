fun main() {
    val strArr = readln().split(" ", "-")
    val arr = arrayOf("c", "j", "n", "m", "t", "s", "l", "d", "qu", "s")
    val vowel = charArrayOf('a', 'e', 'i', 'o', 'u', 'h')
    val result = mutableListOf<String>()

    for (i in strArr.indices) {
        val str = strArr[i].split("'")

        if (str.size > 1 && arr.contains(str[0]) && vowel.contains(str[1][0])) {
            result.add(str[0])
            result.add(str[1])
        } else {
            result.add(strArr[i])
        }
    }
    
    println(result.size)
}
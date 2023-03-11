fun main() {
    val testCaseNum = readln().toInt()
    repeat(testCaseNum) {
        val s = readln()
        val result = isPalindrome(s)
        println("${result.first} ${result.second}")
    }
}

fun recursion(s: String, l: Int, r: Int, num: Int = 1): Pair<Int, Int> {
    return if (l >= r) 1 to num
    else if (s[l] != s[r]) 0 to num
    else recursion(s, l + 1, r -1, num + 1);
}

fun isPalindrome(s: String): Pair<Int, Int> {
    return recursion(s, 0, s.length - 1)
}
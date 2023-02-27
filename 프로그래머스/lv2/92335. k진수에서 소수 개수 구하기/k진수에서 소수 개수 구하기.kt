import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        val result = changeN(n, k)
        var answer = 0
        result.forEach {
            if (it != 1L) {
                var isPrimeNumber = true
                for (i in 1..sqrt(it.toDouble()).toLong()) {
                    if (i != 1L && i != it && it % i == 0L) {
                        isPrimeNumber = false
                        break
                    }
                }
                if (isPrimeNumber) answer++
            }
        }
        return answer
    }

    fun changeN(n: Int, k: Int): List<Long> {
        var result = ""
        var num = n
        var count = 0
        while (num / k > 0) {
            num /= k
            count++
        }

        num = n
        while (count != 0) {
            println("$num / $count")
            var minusNum = k
            repeat(count - 1) { minusNum *= k }
            result += num / minusNum
            num %= minusNum
            --count
        }
        result += num
  
        while (result.contains("00")) { result = result.replace("00", "0") }
        if (result.last() == '0') result = result.removeRange(result.lastIndex..result.lastIndex)
        return result.split("0").map { it.toLong() }
    }
}
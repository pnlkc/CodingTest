class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        var source = makeTernary(n).reversed()
        for (i in source.indices) {
            answer += makePowerOfN(3, source.length - 1 - i) * source[i].toString().toInt()
        }
        
        return answer
    }
    
     fun makeTernary(num: Int): String {
        var x = 1
        var count = 0
        var result = ""
        var number = num

        while (num/x > 0) {
            x *= 3
            count++
        }

        for (i in count - 1 downTo 0) {
            result += (number / makePowerOfN(3, i)).toString()
            number -= makePowerOfN(3, i)*(number / makePowerOfN(3, i))
        }

        return result
    }

    fun makePowerOfN(num: Int, times: Int) : Int {
        var result = 1
        repeat (times) {
            result *= num
        }
        return result
    }
}
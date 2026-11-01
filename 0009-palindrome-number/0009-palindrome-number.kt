class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var result = true
        var size = 0
        var num = x
        var temp = x
        val r = 10
        var l = 1

        while (temp > 0) {
            size++
            temp /= 10
            if (temp > 0) l *= 10
        }

        for (i in 1..(size / 2)) {
            if (num / l != num % r) {
                result = false
                break
            } else {
                num %= l
                num /= r
                l /= 100
            }
        }

        return result
    }
}
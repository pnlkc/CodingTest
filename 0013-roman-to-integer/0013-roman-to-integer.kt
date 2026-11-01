class Solution {
    fun romanToInt(s: String): Int {
        var result = 0
        var pass = false
        
        for (i in s.indices) {
            if (pass) {
                pass = false
                continue
            }
            
            val c = s[i]

            when (c) {
                'I' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                        pass = true
                        result += if (s[i + 1] == 'V') 4 else 9
                    } else {
                        result += 1
                    }
                }
                'V' -> result += 5
                'X' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'L' || s[i + 1] == 'C')) {
                        pass = true
                        result += if (s[i + 1] == 'L') 40 else 90
                    } else {
                        result += 10
                    }
                }
                'L' -> result += 50
                'C' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'D' || s[i + 1] == 'M')) {
                        pass = true
                        result += if (s[i + 1] == 'D') 400 else 900
                    } else {
                        result += 100
                    }
                }
                'D' -> result += 500
                'M' -> result += 1000
            }
        }
        
        return result
    }
}
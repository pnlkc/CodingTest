class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var state = arrayListOf<Int>()
        repeat(n) {
            state.add(1)
        }
        lost.forEach { state[it-1] -= 1 }
        reserve.forEach { state[it-1] += 1 }
        
        var reservePerson = arrayListOf<Int>()
        var lostPerson = arrayListOf<Int>()
        for (i in state.indices) {
            when (state[i]) {
                2 -> reservePerson.add(i)
                0 -> lostPerson.add(i)
            }
        }
        
        reservePerson.forEach {
            if (lostPerson.contains(it-1)) {
                state[it] = 1
                state[it-1] = 1
                lostPerson.remove(it-1)
            } else if (lostPerson.contains(it+1)) {
                state[it] = 1
                state[it+1] = 1
                lostPerson.remove(it+1)
            }
        }
        
        answer = state.count { it >= 1 }
     
        return answer
    }
}
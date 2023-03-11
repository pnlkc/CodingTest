class Solution {
    var answer = mutableListOf<IntArray>()
    
    fun solution(n: Int): Array<IntArray> {
        moveTower(n, 1, 3)
        return answer.toTypedArray()
    }

    fun moveTower(size: Int, start: Int, destination: Int) {
        if (size > 0) {
            moveTower(size - 1, start, 6 - start - destination)
            answer.add(intArrayOf(start, destination))
            moveTower(size - 1, 6 - start - destination, destination)
        }
    }
}
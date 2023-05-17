class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        return (arr.slice(intervals[0][0]..intervals[0][1]) + arr.slice(intervals[1][0]..intervals[1][1])).toIntArray()
    }
}
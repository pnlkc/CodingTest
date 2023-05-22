class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        return finished
            .withIndex()
            .filter { !it.value }
            .map { todo_list[it.index] }
            .toTypedArray()
    }
}
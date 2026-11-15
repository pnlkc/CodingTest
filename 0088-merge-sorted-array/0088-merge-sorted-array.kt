class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val temp = IntArray(m + n)
        var idx = 0
        var idx1 = 0
        var idx2 = 0

        while (idx1 < m || idx2 < n) {
            if (idx1 < m && idx2 < n) {
                temp[idx++] = if (nums1[idx1] <= nums2[idx2]) nums1[idx1++] else nums2[idx2++]
            } else if (idx1 < m) {
                temp[idx++] = nums1[idx1++]
            } else {
                temp[idx++] = nums2[idx2++]
            }
        }

        temp.copyInto(nums1)
    }
}
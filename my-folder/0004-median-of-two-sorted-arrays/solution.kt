class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var A = nums1
        var B = nums2
        if (A.size > B.size) {
            val tmp = A; A = B; B = tmp
        }
        val m = A.size
        val n = B.size
        var left = 0
        var right = m

        val halfLen = (m + n + 1) / 2

        while (left <= right) {
            val i = (left + right) / 2        // cut in A
            val j = halfLen - i              // cut in B

            val Aleft = if (i == 0) Int.MIN_VALUE else A[i - 1]
            val Aright = if (i == m) Int.MAX_VALUE else A[i]
            val Bleft = if (j == 0) Int.MIN_VALUE else B[j - 1]
            val Bright = if (j == n) Int.MAX_VALUE else B[j]

            if (Aleft <= Bright && Bleft <= Aright) {
                val leftMax = maxOf(Aleft, Bleft)
                if ((m + n) % 2 == 1) {
                    return leftMax.toDouble()
                } else {
                    val rightMin = minOf(Aright, Bright)
                    return (leftMax.toDouble() + rightMin.toDouble()) / 2.0
                }
            } else if (Aleft > Bright) {
                right = i - 1
            } else {
                left = i + 1
            }
        }

        throw IllegalArgumentException("Input arrays are not valid sorted arrays")
        }
}

class Solution {

    private val nums = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    private val romanNums = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    
    fun intToRoman(num: Int): String {
        
        var result = ""
        var n = num

        for (i in nums.indices) {
            while (n >= nums[i]) {
                n -= nums[i]
                result += romanNums[i]
            }
        }
        return result
    }
}

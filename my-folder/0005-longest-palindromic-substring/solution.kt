class Solution {
    fun longestPalindrome(s: String): String {
    val modifiedString = preprocessString(s)
    val palindromeLengths = IntArray(modifiedString.length)
    var center = 0
    var right = 0

    for (i in 1 until modifiedString.length - 1) {
        val mirror = 2 * center - i

        if (right > i) {
            palindromeLengths[i] = minOf(right - i, palindromeLengths[mirror])
        }

        while (modifiedString[i + (1 + palindromeLengths[i])] == modifiedString[i - (1 + palindromeLengths[i])]) {
            palindromeLengths[i]++
        }

        if (i + palindromeLengths[i] > right) {
            center = i
            right = i + palindromeLengths[i]
        }
    }

    var maxLength = 0
    var centerIndex = 0
    for (i in 1 until palindromeLengths.size - 1) {
        if (palindromeLengths[i] > maxLength) {
            maxLength = palindromeLengths[i]
            centerIndex = i
            }
        }

        val start = (centerIndex - maxLength) / 2
        val end = start + maxLength

        return s.substring(start, end)
    }

    private fun preprocessString(s: String): String {
        val sb = StringBuilder("^#")
        for (c in s) {
            sb.append(c)
            sb.append("#")
        }
        sb.append("$")
        return sb.toString()
    }
}


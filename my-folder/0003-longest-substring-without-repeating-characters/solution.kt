class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        
        var str = ""
        var num = 0
        
        for(i in s){
            if(str.contains(i)){
                str = str.substring(str.indexOf(i)+1) + i
                continue   
            }
            str += i
			if(num < str.length)
            	num = str.length

        }
        return num
    }
}

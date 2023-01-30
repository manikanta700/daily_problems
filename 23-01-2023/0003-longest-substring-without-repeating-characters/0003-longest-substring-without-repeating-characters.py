class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        msl=0
        l=0
        r=0
        if(len(s)<1):
            return 0
        temp={}
        while(r<len(s)):
            if(s[r]  in list(temp.keys())):
                
                l=max(temp[s[r]]+1,l)
            temp[s[r]]=r
            if msl<r-l+1:
                msl=r-l+1
            r+=1

        return msl
        
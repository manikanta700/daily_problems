class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        i=0
        ans=0
        if(i==len(s)):
         
            return 0
        while(i<len(s) and (s[i] < '0' or s[i] > '9') and s[i]!='-' and s[i]!='+'):
            if(s[i]!=' '):
              
                return 0
            i+=1
        sig=1
        if(i>=len(s)):
         
            return 0
        if(s[i]=='-'):
            sig=-1
            i+=1
        elif(s[i]=="+"):
            sig=1
            i+=1
        
        while(i<len(s) and s[i] >= '0' and s[i] <= '9' ):
            ans=ans*10+(ord(s[i])-ord('0'))
            i+=1
        
        if ans*sig > 2**31 - 1:
            return 2**31 -1
        elif ans*sig < -1*(2**31):
            return -1*(2**31)
        else:
            return ans*sig
        
        
        
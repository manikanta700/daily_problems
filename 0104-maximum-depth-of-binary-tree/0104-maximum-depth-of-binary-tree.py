# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        
        lisQ=[]
        lisQ.append(root)
        
        lev=0
        
        while(len(lisQ)>0):
            subres=[]
            n=len(lisQ)
            for i in range(n):
               # print(len(lisQ))
                subres.append(lisQ[i].val)
                if(lisQ[i].left!=None):
                    lisQ.append(lisQ[i].left)
                if(lisQ[i].right!=None):
                    lisQ.append(lisQ[i].right)
                 
            lev+=1
            for i in range(n):
                lisQ.pop(0)
        return lev
        
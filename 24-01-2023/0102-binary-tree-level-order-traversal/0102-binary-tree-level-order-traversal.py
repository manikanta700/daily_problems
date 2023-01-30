# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if root==None:
            return []
        
        lisQ=[]
        lisQ.append(root)
        
        res=[]
        
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
                 
            res.append(subres)
            for i in range(n):
                lisQ.pop(0)
        return res
                    
                    
            
                
        
        
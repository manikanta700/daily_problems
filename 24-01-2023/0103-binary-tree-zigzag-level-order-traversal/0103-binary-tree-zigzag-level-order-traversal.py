# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return []
        
        lisQ=[]
        lisQ.append(root)
        
        res=[]
        le=1
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
                    
                 
            if(le%2==0):
                res.append(subres[::-1])
            else:
                res.append(subres)
            le+=1
                
            for i in range(n):
                lisQ.pop(0)
        return res
        
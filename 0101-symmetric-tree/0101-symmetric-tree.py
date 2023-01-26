# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isSym(left,right):
            if left==None and right==None:
                return True
            if left==None or right==None:
                return False
            return left.val==right.val and isSym(left.left,right.right) and isSym(right.left,left.right)

        if root==None:
            return True
        return isSym(root.left,root.right)
    
        
        
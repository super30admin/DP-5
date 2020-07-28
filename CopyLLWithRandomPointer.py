-------------------------------- copy linked list with random pointer ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# To copy a LL with random pointer, I will iterate through the list and 
#check if the node is present in the dict or not , if not I will create a copy node and 
#place in the dict and check for same clone function to initialize next and random pointers.



class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not  head:
            return None
        
        def clone(node):
            if not node:
                return None
            
            if node not in d:
                d[node] = Node(node.val)
           
            return d[node]
                
        d = {}
        temp= clone(head)
        curr = head
        while temp!=None:
            temp.next = clone(curr.next)
            temp.random = clone(curr.random)
            temp = temp.next
            curr = curr.next
        
        return d[head]
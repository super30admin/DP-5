//138. Copy List with Random Pointer.java

//Space:O(1)
//Time:O(n)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //edge case
        if(head == null)
            return null;
        Node temp = head;
        int count = 0;
        while(temp!=null){
            
            
            //create new node
            Node newNode = new Node(temp.val);
            
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }
        
        Node current = head;
        while(current != null){
            
            
            Node currentRandom = current.random;
            Node newCurrent = current.next;
            Node newRandom  = null;
            if(currentRandom != null)
                newRandom = currentRandom.next;
            newCurrent.random = newRandom;
            current = current.next.next;
            
        }
        
        Node newHead = head.next;
        current = head;
        while(current != null){
            Node nextCurrent = current.next.next;
            Node newCurrent = current.next;
            
            Node newNextCurrent = null;
            if(current.next.next != null)
                 newNextCurrent = current.next.next.next;
            newCurrent.next = newNextCurrent;
           
            current.next = nextCurrent;
            current = nextCurrent;
        }
        return newHead;
    }
}

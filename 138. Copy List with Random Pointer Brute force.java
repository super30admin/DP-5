//138. Copy List with Random Pointer.java
//Time:O(n)
//Space:O(n)
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
        
        
        //create newList with structure
        //update the original list vals by their index
      
        Node temp = head;
        int size = 0;
        while(temp!= null){
            size++;
            temp = temp.next;
        }
        temp = head;
        int count = 0;
        Node[] nodes = new Node[size];
        Node newHead =null;
        Node newNode = null;
        Node prev = null;
        while(temp != null){
            //create new node
            prev = newNode;
            newNode = new Node(temp.val);
            temp.val = count;
            if(count == 0)
                newHead = newNode;
            nodes[count] = newNode;
            //connecting nodes
            if(prev!= null)
                prev.next = newNode;
            temp = temp.next;
            
            count++;
        }
        temp = head;
        while(temp != null){
            
            Node currentNode = nodes[temp.val];
        
            if(temp.random != null){
                Node randNode = temp.random;
                currentNode.random = nodes[randNode.val];
            }
            temp = temp.next;
        }
        return newHead;
        
    }
}

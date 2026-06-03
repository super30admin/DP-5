// Time Complexity : O(k log n) because we perform k heap operations and heap size is at most n
// Space Complexity : O(n) for the Min Heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We treat each row as a sorted list and use a Min Heap to always access the smallest available element.
// Initially, we insert the first element from every row into the heap.
// Each time we remove the smallest element, we insert the next element from the same row and after k-1 removals, the heap top is the kth smallest element.

class Solution {

    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        // min heap based on value
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        // add first element of each row
        for (int r = 0; r < n; r++) {
            pq.add(new Node(r, 0, matrix[r][0]));
        }

        // remove k-1 smallest elements
        while (k != 1) {

            Node curr = pq.poll();

            // add next element from same row
            if (curr.col + 1 < n) {
                pq.add(new Node(
                    curr.row,
                    curr.col + 1,
                    matrix[curr.row][curr.col + 1]
                ));
            }

            k--;
        }

        return pq.peek().val;
    }
}
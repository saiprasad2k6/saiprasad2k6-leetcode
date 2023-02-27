/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int m = grid.length; //Cols
        int n = grid[0].length; //Rows

        return traverse(grid, 0, 0,grid.length);

    }

    private Node traverse(int[][] A, int r, int c, int length) {
        //Base Case
        if (length == 1) {
            return new Node(A[r][c] == 1 ? true : false, true);
        }

        //Calculation for Navigation

        Node topLeft = traverse(A, r, c, length / 2);
        Node topRight = traverse(A, r, c + length / 2, length / 2);
        Node bottomLeft = traverse(A, r + length / 2, c, length / 2);
        Node bottomRight = traverse(A, r + length / 2, c + length / 2, length / 2);

        boolean isNodeALeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean isNodeSame = (topLeft.val == topRight.val) && (bottomLeft.val == bottomRight.val) && (topLeft.val == bottomLeft.val);
         
        //If all the Corners are Leaf, then this node must be leaf
        if (isNodeALeaf && isNodeSame) {
            return new Node(topLeft.val, true);
        }
        //else
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
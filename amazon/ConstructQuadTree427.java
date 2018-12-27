//https://leetcode.com/problems/construct-quad-tree/

class Node{
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node(){}
    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight){
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomRight;
        bottomRight = _bottomRight;
    }

};

class Solution{
    public Node construct(int[][] grid){
        return build(0, 0, grid.length-1, grid.length-1, grid);
    }
    Node build(int r1, int c1, int r2, int c2, int[][] g){
        if(r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = g[r1][c1];
        
            }
}

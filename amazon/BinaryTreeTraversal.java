////Tree Inorder,Preorder, PostOrder traversal.
//Reference: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeTraversal{
    Node root;
    public BinaryTreeTraversal(){
        root = null;
    }

    void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data+",");
        printInorder(node.right);
    }

    void printPreorder(Node node){
        if (node == null) return;
        System.out.print(node.data + ",");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(Node node){
        if(node == null )
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data+ ",");
    }
    //wrappers over above recursive fuctions
    void printInorder(){
        printInorder(root);
    }
    void printPreorder(){
        printPreorder(root);
    }
    void printPostorder(){
        printPostorder(root);
    }

    public static void main(String[] args){
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Below is printInorder result: ");
        tree.printInorder();
        System.out.println("\nBelow is printPreorder result: ");
        tree.printPreorder();
        System.out.println("\nBelow is printPostorder result: ");
        tree.printPostorder();
    }
}


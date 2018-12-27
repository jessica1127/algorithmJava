import java.util.*;


class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTreeSerializeDeserialize297{
    Node root;
    public static final String filter = ",";
    public static final String NN = "X";

    public String serialize(Node node){
        StringBuffer sb = new StringBuffer();
        buildString(node, sb);
        return sb.toString();
    }
    private String buildString(Node node, StringBuffer sb){
        if(node == null){
            sb.append(NN).append(filter);
        }else{
            sb.append(node.data).append(filter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
        return sb.toString();
    }


    public Node deserialize(String data){
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(filter)));
        return buildTree(nodes);
    }   
    private Node buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if (val == NN){
            return null;
        }else{
            Node node = new Node(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args){
        BinaryTreeSerializeDeserialize297 bt = new BinaryTreeSerializeDeserialize297();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.right.left = new Node(5);
        bt.root.right.right = new Node(6);

        String serialize_result = bt.serialize(bt.root);
        System.out.println(serialize_result);
       

    }
}



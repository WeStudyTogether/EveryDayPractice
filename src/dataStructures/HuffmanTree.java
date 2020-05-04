package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
* @author Guangyao Gou
* @date 2020/53/11 09:53:13
* @ClassName HuffmanTree.java
* @Description 类描述
*/

public class HuffmanTree {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffmanTRee(arr);
        
        preOrder(root);
         
    }
    public static Node createHuffmanTRee(int arr[]) {
        List<Node> nodes = new ArrayList<Node>();
        for(int value : arr) {
            nodes.add(new Node(value));
        }
        while(nodes.size() > 1) {
            Collections.sort(nodes);
            
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent  = new Node(left.value+right.value);
            parent.left = left;
            parent.right = right;
                   
            nodes.remove(left);
            nodes.remove(right);
            
            nodes.add(parent);
            
        }
        return nodes.get(0);
    }

    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("Empty");
        }
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return this.value - o.value;
    }
    
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
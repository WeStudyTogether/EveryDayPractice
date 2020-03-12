package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guangyao Gou
 * @date 2020/26/11 11:26:43
 * @ClassName HuffmanCode.java
 * @Description 类描述
 */

public class HuffmanCode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String content = "i like like like java do you like a java";
        byte[] contentbytes = content.getBytes();

        List<Node2> nodes = getNodes(contentbytes);
        Node2 root= createHuffmanTree(nodes);
        root.preOrder();
        
        getCodes(root);
        System.out.println(huffmanCodes);
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    private static Map<Byte, String> getCodes(Node2 root) {
        if(root == null) {
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    
    private  static void getCodes(Node2 node, String code,StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        
        if(node != null) {
            if(node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            }else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }
    
    private static void preOrder(Node2 root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("EMpty");
        }
    }

    private static List<Node2> getNodes(byte[] bytes) {
        ArrayList<Node2> nodes = new ArrayList<Node2>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);

            } else { 
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node2 createHuffmanTree(List<Node2> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node2 left = nodes.get(0);
            Node2 right = nodes.get(1);
            Node2 parent = new Node2(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

        }
        return nodes.get(0);

    }    
}

class Node2 implements Comparable<Node2> {
    Byte data;
    int weight;
    Node2 left;
    Node2 right;

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node2 o) {
        // TODO Auto-generated method stub
        return this.weight - o.weight;
    }
}
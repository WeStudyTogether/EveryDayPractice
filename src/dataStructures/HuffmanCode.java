package dataStructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
        Node2 root = createHuffmanTree(nodes);
        root.preOrder();
        getCodes(root);
        byte[] huffmanCodeBytes = zip(contentbytes, huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(sourceBytes));
        
        
    }
    
    public  static void UnZipFile(String zipFile,String dstFile) {
        InputStream is = null;
        ObjectInputStream ois =null;
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                os.close();
                is.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
    }
    
    public static void zipFile(String srcFile,String dstFile) {
        InputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos =null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            List<Node2> nodes = getNodes(b);
            Node2 root = createHuffmanTree(nodes);
            root.preOrder();
            getCodes(root);

            byte[] huffmanCodeBytes = zip(b, huffmanCodes);
            
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanCodeBytes);
            oos.writeObject(huffmanCodes);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private static byte[] decode(Map<Byte, String> huffmanCodes,byte[] huffmanBytes){ 
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<huffmanBytes.length;i++) {
            boolean flag = (i == huffmanBytes.length - 1);
           stringBuilder.append(byteTobitString(!flag, huffmanBytes[i])) ;
        }
        
        Map<String, Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte,String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        
        List<Byte> list = new ArrayList<>();
        for(int i = 0; i<stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b =null;
             while(flag) {
                 String key = stringBuilder.substring(i,i+count);
                 b = map.get(key);
                 if(b == null) {
                     count++;
                 }else {
                     flag = false;
                 }
             }
             i += count;
             list.add(b);
            
        }
        byte[] b = new  byte[list.size()];
        for(int i = 0; i<b.length;i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteTobitString(boolean flag, byte b) {
        int temp = b;
        if(flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }

    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }

            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node2 root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node2 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);

        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
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
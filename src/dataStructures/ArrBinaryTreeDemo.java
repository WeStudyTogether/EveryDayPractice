package dataStructures;

/**
 * @author Guangyao Gou
 * @date 2020/17/09 17:17:25
 * @ClassName ArrBinaryTreeDemo.java
 * @Description 类描述
 */

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.infixOrder(0);
    }
}

class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        super();
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Empty");
        }
        System.out.println(arr[index]);

        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
    
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Empty");
        }
        

        if ((2 * index + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if ((2 * index + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }
}
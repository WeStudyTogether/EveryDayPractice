package dataStructures;

/**
 * @author Guangyao Gou
 * @date 2020/14/08 18:14:49
 * @ClassName BinaryTree.java
 * @Description 类描述
 */

public class BinaryTree {
    private treeHeroNode root;

    public void setRoot(treeHeroNode root) {
        this.root = root;
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("Empty");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("Empty");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("Empty");
        }
    }
    public static void main(String[] args) {
        BinaryTree binarytree = new BinaryTree();

        treeHeroNode root = new treeHeroNode(1, "a");
        treeHeroNode node2 = new treeHeroNode(2, "b");
        treeHeroNode node3 = new treeHeroNode(3, "c");
        treeHeroNode node4 = new treeHeroNode(4, "d");
        treeHeroNode node5 = new treeHeroNode(5, "e");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binarytree.setRoot(root);
        binarytree.infixOrder();
    }

}

class treeHeroNode {
    private int no;
    private String name;
    private treeHeroNode left;
    private treeHeroNode right;

    public treeHeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public treeHeroNode getLeft() {
        return left;
    }

    public void setLeft(treeHeroNode left) {
        this.left = left;
    }

    public treeHeroNode getRight() {
        return right;
    }

    public void setRight(treeHeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
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

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
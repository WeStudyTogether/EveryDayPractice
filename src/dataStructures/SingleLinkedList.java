package dataStructures;

import java.util.Stack;

/**
 * @author Guangyao Gou
 * @date 2020/38/28 23:38:13
 * @ClassName SingleLinkedList.java
 * @Description 类描述
 */

public class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("empty");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("没有编号为" + heroNode.no + "的节点\n");
        }
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;// 判断是否已经存在
        while (true) {
            if (temp.next == null) {// 添加到末尾
                break;
            }
            if (temp.next.no > heroNode.no) {// 找到插入位置的前一位
                break;
            } else if (temp.next.no == heroNode.no) {// 已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("already exit:" + heroNode.no + "");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void delete(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有编号为" + heroNode.no + "的节点");
        }
    }

    // 显示
    public void list() {
        if (head.next == null) {
            System.out.println("empty");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode curr = head.next;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public static HeroNode findLastIndexNode(int index, HeroNode head) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode curr = head.next;
        for (int i = 0; i < size - index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    //反转
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseNode = new HeroNode(0, "", "");
        HeroNode curr = head.next;
        HeroNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = reverseNode.next; 
            reverseNode.next = curr;
            curr = next;
        }
        head.next = reverseNode.next;
    }
    
    //利用栈逆序打印
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;
        }
        Stack<HeroNode>stack = new Stack<>();
        HeroNode curr = head.next;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
       while(stack.size()>0) {
           System.out.println(stack.pop());
       }
    }

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "龙行超", "lxc");
        HeroNode hero2 = new HeroNode(2, "苟光耀", "ggy");
        HeroNode hero3 = new HeroNode(3, "张和平", "zhp");
        HeroNode hero4 = new HeroNode(4, "李钰", "ly");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(3, "和平", "hp");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后：");
        singleLinkedList.list();
        
        System.out.println("节点总个数（不包括head）：" + getLength(singleLinkedList.getHead()));
        
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        
        System.out.println("用栈逆序输出：");
        reversePrint(singleLinkedList.getHead());
         
        System.out.println("倒数第二个：");
        HeroNode lastHeroNode = findLastIndexNode(2, singleLinkedList.getHead());
        System.out.println(lastHeroNode);

        System.out.println("删除后：");
        singleLinkedList.delete(hero3);
        singleLinkedList.delete(hero1);
        singleLinkedList.delete(hero4);
        singleLinkedList.list();
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hno, String hname, String hnickname) {
        this.no = hno;
        this.name = hname;
        this.nickname = hnickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
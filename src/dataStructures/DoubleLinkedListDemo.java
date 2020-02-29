package dataStructures;

/**
 * @author Guangyao Gou
 * @date 2020/18/29 14:18:25
 * @ClassName DoubleLinkedListDemo.java
 * @Description 类描述
 */

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "龙行超", "lxc");
        HeroNode2 hero2 = new HeroNode2(2, "苟光耀", "ggy");
        HeroNode2 hero3 = new HeroNode2(3, "张和平", "zhp");
        HeroNode2 hero4 = new HeroNode2(4, "李钰", "ly");

        DoubleLinkedList  doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
        DoubleLinkedList.addByOrder(hero1);
        DoubleLinkedList.addByOrder(hero4);
        DoubleLinkedList.addByOrder(hero3);
        DoubleLinkedList.addByOrder(hero2);
        
        doubleLinkedList.list();
        
        HeroNode2 hero = new HeroNode2(3, "和平", "hp");
        doubleLinkedList.update(hero);
        System.out.println("修改后~~~");
        doubleLinkedList.list();
        
        doubleLinkedList.delete(hero3);
        System.out.println("删除后~~~");
        doubleLinkedList.list();
    }

}

class DoubleLinkedList {
    private static HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }
    
    public static void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
            if(temp.next!=null) {
                temp.next.pre = heroNode;
            }
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("empty");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("empty");
            return;
        }
        HeroNode2 temp = head.next;
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
    
    public void delete(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
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
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        } else {
            System.out.println("没有编号为" + heroNode.no + "的节点");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hno, String hname, String hnickname) {
        this.no = hno;
        this.name = hname;
        this.nickname = hnickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
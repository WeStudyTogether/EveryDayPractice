package dataStructures;

/**
 * @author Guangyao Gou
 * @date 2020/26/29 23:26:02
 * @ClassName Josephu.java
 * @Description 类描述
 */

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums wrong");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("Empty");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入有误");
            return;
        }
        Boy helper = first;// 辅助指针先指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 第startno小孩报数前，first和helper先移动startno-1
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时first和helper移动countNum-1
        while(true) {
            if(first == helper) {//只有一个节点了
                break;
            }
            for(int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩"+first.getNo()+"出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号"+first.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
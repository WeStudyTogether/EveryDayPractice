package dataStructures;

import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/24/28 20:24:36
 * @ClassName CircleArrayQueue.java
 * @Description 类描述
 */

public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxsize) {
        maxSize = maxsize;
        arr = new int[maxSize];
        front = 0;// 队列第一个数据
        rear = 0;// 队列最后一个数据的后一个位置
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        int frontvalue = arr[front];
        front = (front + 1) % maxSize;
        return frontvalue;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return arr[front];
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);//有效数据最大为3
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:show");
            System.out.println("e:exit");
            System.out.println("a:add");
            System.out.println("g:get");
            System.out.println("h:head");
            key = scanner.next().charAt(0);
            switch (key) {
            case 's': {
                queue.showQueue();
                break;
            }
            case 'a': {
                System.out.println("输入一个数：");
                int value = scanner.nextInt();
                queue.addQueue(value);
                break;
            }
            case 'g': {
                int res = queue.getQueue();
                System.out.println(res);
                break;
            }
            case 'h': {
                int res = queue.headQueue();
                System.out.println(res);
                break;
            }
            case 'e': {
                scanner.close();
                loop = false;
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + key);
            }

        }
    }
}

package dataStructures;

import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/57/28 17:57:09
 * @ClassName ArrayQueue.java
 * @Description 类描述
 */

public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxsize) {
        maxSize = maxsize;
        arr = new int[maxSize];
        front = -1;// 队列头前一个位置
        rear = -1;// 队列最后一个数据

    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return arr[front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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

package dataStructures;

import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/05/01 11:05:58
 * @ClassName ArrayStack.java
 * @Description 类描述
 */

public class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] stack;
    
    public ArrayStack(int maxs) {
        this.maxSize = maxs;
        stack = new int[this.maxSize];       
    }
    
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    public boolean isEmpty() {
        return top ==-1;
    }
    
    public void push(int value) {
        if(isFull()) {
            System.out.println("Full");
            return;
        }
        top++;
        stack[top] = value;
                
    }
    
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Empty");
        }
        int value = stack[top];
        top--;
        return value;
        
    }
    
    public void list() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for(int i = top; i>-1; i--) {
            System.out.println("stack["+i+"] = "+stack[i]);
        }
    }
    
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        
        while(loop) {
            System.out.println("s:show");
            System.out.println("e:exit");
            System.out.println("pu:push");
            System.out.println("po:pop");
            key = scanner.next();
            switch (key) {
            case "s": {
             arrayStack.list();
             break;
            }
            case "e": {
                scanner.close();
                loop = false;
                break;
            }
            case "pu": {
                System.out.println("请输入一个数：");
                int value;
                value = scanner.nextInt();
                arrayStack.push(value);
                break;
            }
            case "po": {
                try {
                    int res = arrayStack.pop();
                    System.out.println("出栈数据为："+res);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                
            }           
            default:
                break;
            }
        }
    }
    
}

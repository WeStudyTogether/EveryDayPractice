package dataStructures;

/**
 * @author Guangyao Gou
 * @date 2020/38/01 17:38:40
 * @ClassName Calculator.java
 * @Description 类描述
 */

public class Calculator {

    public static void main(String[] args) {
        String string = "70+2*6-40";
        ArrayStack2 num = new ArrayStack2(10);
        ArrayStack2 oper = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int ope = 0;
        char ch = ' ';
        String KeepNum = "";// 多位数

        while (true) {
            ch = string.substring(index, index + 1).charAt(0);
            if (oper.isOper(ch)) {
                if (!oper.isEmpty()) {
                    if (oper.priority(ch) <= oper.priority(oper.peek())) {
                        num1 = num.pop();
                        num2 = num.pop();
                        ope = oper.pop();
                        res = num.cal(num2, num1, ope);
                        num.push(res);
                        oper.push(ch);
                    } else {
                        oper.push(ch);
                    }
                } else {
                    oper.push(ch);
                }

            } else {
                KeepNum += ch;
                if (index == string.length() - 1) {
                    num.push(Integer.parseInt(KeepNum));
                } else {
                    if (num.isOper(string.subSequence(index + 1, index + 2).charAt(0))) {
                        num.push(Integer.parseInt(KeepNum));
                        KeepNum = "";
                    }
                }
            }
            index++;
            if (index >= string.length()) {
                break;
            }
        }

        while (true) {
            if (oper.isEmpty()) {
                break;
            }
            num1 = num.pop();
            num2 = num.pop();
            ope = oper.pop();
            res = num.cal(num2, num1, ope);
            num.push(res);
        }
        System.out.println(num.pop());
    }

}

class ArrayStack2 {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack2(int maxs) {
        this.maxSize = maxs;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        top++;
        stack[top] = value;

    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        int value = stack[top];
        top--;
        return value;

    }

    public void list() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int nums1, int nums2, int oper) {
        int res = 0;
        switch (oper) {
        case '+': {
            res = nums1 + nums2;
            break;
        }
        case '-': {
            res = nums1 - nums2;
            break;
        }
        case '*': {
            res = nums1 * nums2;
            break;
        }
        case '/': {
            res = nums1 / nums2;
            break;
        }
        default:
            break;
        }
        return res;
    }

    public int peek() {
        return stack[top];
    }
}
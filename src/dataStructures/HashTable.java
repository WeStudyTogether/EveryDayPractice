package dataStructures;

import java.util.Scanner;

/**
 * @author Guangyao Gou
 * @date 2020/20/05 17:20:02
 * @ClassName HashTable.java
 * @Description 类描述
 */

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:");
            System.out.println("exit:");
            System.out.println("find");
            System.out.println("del");

            key = scanner.next();
            switch (key) {
            case "add":
                int id = scanner.nextInt();
                String name = scanner.next();
                Emp emp = new Emp(id, name);
                hashTab.add(emp);
                break;
            case "list":
                hashTab.list();
                break;
            case "find":
                id = scanner.nextInt();
                hashTab.findEMpById(id);
                break;
            case "del":
                id = scanner.nextInt();
                hashTab.delEmpById(id);
                break;
            case "exit":
                scanner.close();
                System.exit(0);
            default:
                break;
            }

        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                curEmp.next = emp;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public void list() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.println(curEmp.id+","+curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }

    }
    
    public Emp findEMpById(int id) {
        if(head == null) {
            System.out.println("empty");
            return null;
        }
        Emp curemp = head;
        while(true){
            if(curemp.id == id) {
                break;
            }
            if(curemp.next == null) {
                curemp = null;
            }
            curemp = curemp.next;
            
        }
        return curemp;
    }
    
    public void delEmpById(int id) {
        if(head == null) {
            System.out.println("empty");
            return;
        }
        Emp curemp = head;
        if(curemp.id == id) {
           if(curemp.next != null) {
                curemp = curemp.next;
            }else {
                curemp = null;
            }
            return;
        }
        while(true){
            if(curemp.next.id == id) {
                if(curemp.next.next != null) {
                    curemp.next = curemp.next.next;
                    break;
                }else {
                    curemp.next = null;
                    break;
                }
                
            }
            if(curemp.next == null) {
                System.out.println("无");
            }
            curemp = curemp.next;
            
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int emplinkedlistNo = hashFun(emp.id);
        empLinkedListArray[emplinkedlistNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }
    
    public void findEMpById(int id) {
        int emplinkedlistNo = hashFun(id);
        Emp emp = empLinkedListArray[emplinkedlistNo].findEMpById(id);
        if(emp != null) {
            System.out.println(emplinkedlistNo+1);
        }else {
            System.out.println("未找到");
        }
    }

    public void delEmpById(int id) {
        int emplinkedlistNo = hashFun(id);
        empLinkedListArray[emplinkedlistNo].delEmpById(id);
    }
    public int hashFun(int id) {
        return id % size;
    }
}
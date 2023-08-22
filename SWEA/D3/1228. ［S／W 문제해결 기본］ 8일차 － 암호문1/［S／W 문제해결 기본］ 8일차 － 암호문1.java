import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            MyLinkedList myList = new MyLinkedList();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < N; i++) {
                myList.addLast(Integer.parseInt(st1.nextToken()));
            }
             
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < M; i++) {
                st2.nextToken();
                int X = Integer.parseInt(st2.nextToken());
                int Y = Integer.parseInt(st2.nextToken());
                 
                for (int j = 0; j < Y; j++) {
                    int num = Integer.parseInt(st2.nextToken());
                    myList.add(X + j, num);
                }
            }
             
            sb.append("#" + tc);
            Node c = myList.head;
            for (int i = 0; i < 10; i++) {
                sb.append(" " + c.data);
                c = c.next;
            }
            sb.append("\n");
        }
         
        System.out.println(sb);
    }
}
 
class Node {
    int data;
    Node next;
     
    public Node(int data) {
        this.data = data;
    }
}
 
class MyLinkedList {
    Node head;
    int size;
     
    void addFirst(int data) {
        Node node = new Node(data);
 
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            node.next = temp;
            head = node;
        }
         
        size++;
    }
     
    void addLast(int data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node node = new Node(data);
             
            Node c = head;
            while (c.next != null) {
                c = c.next;
            }
             
            c.next = node;
             
            size++;
        }
    }
     
    void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
         
        if (idx == size) {
            addLast(data);
            return;
        }
         
        Node node = new Node(data);
        Node c = head;
        for (int i = 0; i < idx - 1; i++) {
            c = c.next;
        }
        Node temp = c.next;
         
        c.next = node;
        node.next = temp;
        size++;
    }
}
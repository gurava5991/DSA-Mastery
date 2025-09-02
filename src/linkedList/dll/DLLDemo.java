package linkedList.dll;

import java.util.List;

class ListNode {
    int data;
    ListNode next;
    ListNode prev;
    public ListNode(int data) {
        this.data = data;
    }
    public ListNode(int data, ListNode next, ListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
public class DLLDemo {
    public static void main(String[] args) {
        int[] arr = {4 , 5 , 6 , 7 , 9 };
        ListNode head = convertArrayToDLL(arr);
        printDLL(head);// Traversal of DLL , Length of DLL , search in DLL
        System.out.println("insert Node before head");
        head= insertBeforeHead(head , 3);
        printDLL(head);
        System.out.println("insert Node before tail");

        head = insertBeforeTail(head , 8 );
        printDLL(head);
        System.out.println("insert Node before kth position");

        head = insertBeforeKthPosition(head , 3 , 20);
        printDLL(head);
        System.out.println();

        // deleteHead , deleteTail , deleteKthPosition
        System.out.println("delete operations");
        System.out.println("\ndelete node at head");
        head = deleteHead(head);
        printDLL(head);
        System.out.println("\ndelete node at tail");

         head = deleteTail(head);
         printDLL(head);
         System.out.println("\ndelete node at kth position");

         head = deleteKthPosition(head , 3);
         printDLL(head);
    }

    private static ListNode deleteKthPosition(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count ++;
            if(count == k){
                break;
            }
            curr = curr.next;
        }
        ListNode prevNode = curr.prev;
        ListNode nextNode = curr.next;

        if(prevNode == null && nextNode == null){
            return null;
        } else if (prevNode == null) {
            deleteHead(head);
        } else if (nextNode == null) {
            curr.prev.next = null;
            curr.prev = null;
        }else{
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        return head;
    }

    private static ListNode deleteTail(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        curr.prev = null;
        return head;
    }

    private static ListNode deleteHead(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    private static ListNode insertBeforeKthPosition(ListNode head, int k, int val) {
        if(k == 1){
            return insertBeforeHead(head , val);
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count ++;
            if(count == k){
                ListNode prev = curr.prev;
                ListNode newNode = new ListNode(val , curr , prev);
                prev.next = newNode;
                curr.prev = newNode;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    private static ListNode insertBeforeTail(ListNode head, int val) {
        if(head == null){
            return new ListNode(val);
        }
        if(head.next == null){
            return insertBeforeHead(head , val);
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode prev = curr.prev;
        ListNode newNode = new ListNode(val , curr , prev);
        prev.next = newNode;
        curr.prev = newNode;
        return head;
    }

    private static ListNode insertBeforeHead(ListNode head, int val) {
        ListNode newNode = new ListNode(val , head , null);
        head.prev = newNode;
        return newNode;
    }

    private static void printDLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    private static ListNode convertArrayToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }
        return head;
    }
}

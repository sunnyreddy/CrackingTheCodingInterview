package LinkedLists;

import java.util.HashSet;

public class RemoveDups {
    public static void removeDups(LinkedListNode head) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;
        while(head != null) {
            if (set.contains(head.data)) {
                prev.next = head.next;
            } else {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    public static void removeDups2(LinkedListNode head) {
        LinkedListNode curr = head;
        while(curr != null) {
            LinkedListNode runner = curr;
            while(runner.next != null) {
                if(runner.next.data == curr.data){
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        removeDups2(head);
        System.out.println(head.printForward());
    }
}

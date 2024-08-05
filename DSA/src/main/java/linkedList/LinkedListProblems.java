package linkedList;

public class LinkedListProblems {


    public static ListNode mergeTwoSortedLinkedList(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode newHead = null;
        if (listNode1.val <= listNode2.val) {
            newHead = listNode1;
            listNode1 = listNode1.next;
        } else {
            newHead = listNode2;
            listNode2 = listNode2.next;
        }

        ListNode head = newHead;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                head.next = listNode1;
                head = listNode1;
                listNode1 = listNode1.next;
            } else {
                head.next = listNode2;
                head = listNode2;
                listNode2 = listNode2.next;
            }
        }
        if (listNode1 != null) {
            head.next = listNode1;
        }
        if (listNode2 != null) {
            head.next = listNode2;
        }
        return newHead;
    }


    public static ListNode mergeSortedRecursive(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head;
        if (a.val <= b.val) {
            head = a;
            head.next = mergeSortedRecursive(a.next, b);
        } else {
            head = b;
            head.next = mergeSortedRecursive(a, b.next);
        }
        return head;
    }

    public static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(midNext);
        return mergeSortedRecursive(left, right);
    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(8, n4);
        ListNode n2 = new ListNode(11, n3);
        ListNode n1 = new ListNode(1, n2);


        ListNode m3 = new ListNode(6, null);
        ListNode m2 = new ListNode(4, m3);
        ListNode m1 = new ListNode(2, m2);

        //ListNode head = mergeTwoSortedLinkedList(n1, m1);
        //ListNode head = mergeSortedRecursive(n1, m1);
        ListNode head = sortLinkedList(n1);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }
}

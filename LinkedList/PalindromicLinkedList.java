package LinkedList;
public class PalindromicLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = head;
        ListNode temp = head;

        while (temp.next != null && temp.next.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }

        ListNode curr = mid.next;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode d2 = prev;
        ListNode d1 = head;
        boolean isPalindrome = true;

        while (d1 != null && d2 != null) {
            if (d1.val != d2.val) {
                isPalindrome = false;
            }

            d1 = d1.next;
            d2 = d2.next;
        }

        curr = prev;
        prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        mid.next = prev;
        return isPalindrome;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(1);

        print(l1);
        System.out.println(isPalindrome(l1));
        print(l1);
    }
}
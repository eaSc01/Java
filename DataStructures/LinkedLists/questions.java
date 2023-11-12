public class questions {
    class ListNode {
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

    class reverseLinkedListIII {

        // reverses LL from node at val left to node at val right
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // approach, dividing List into 3 parts, left, right, and mid (mid will be
            // reversed)
            // corner cases
            if (head == null || head.next == null) {
                return head;
            }
            if (left == right) {
                return head;
            }

            // leftList will point to predecessor of the node which value is equal to left
            // rightList will point to successor of the node which val is equal to right
            ListNode leftList = head;
            ListNode rightList = head;
            ListNode midList = null;
            ListNode midEnd = null;

            // traversing left to correct position
            while (leftList != null) {
                if (leftList.next.val == left) {
                    midList = leftList.next; // midList point to node that has value of left
                    break;
                }
                leftList = leftList.next;
                rightList = rightList.next; // moving right too because left <= right
            }

            if (midList == null) {
                return head;
            }

            // traversing right to correct position
            while (rightList != null) {
                if (rightList.val == right) {
                    midEnd = rightList; // midEnd points to the node that has value of right
                    rightList = rightList.next;
                    break;
                }
                rightList = rightList.next;
            }

            if (midEnd == null) {
                return head;
            }

            // now reversing
            ListNode prev = null;
            ListNode curr = midList;

            while (curr != rightList) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // necessary connections after reversing
            leftList.next = prev;
            midList.next = rightList;

            return head;
        }
    }

}
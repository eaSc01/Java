public class LinkedList {

    public static class Node {
        // blueprint of a node

        int data;
        Node next;

        public Node(int data) {
            // initializes data
            this.data = data;
        }
    }

    public static Node head; // points to starting of list
    public static Node tail; // points to ending of list
    static int size;

    public void addFirst(int data) {
        // to add elements at the beginning of list

        Node newNode = new Node(data); // creation of a new node
        size++;

        if (head == null) {
            // very first node of the List, empty list
            head = tail = newNode;
            newNode.next = null;
            return;
        }

        // appending new nodes in existing list
        newNode.next = head; // link
        head = newNode; // update head
    }

    public void addLast(int data) {
        // to add elements at the end of list

        Node newNode = new Node(data); // creation of a new node
        size++;

        if (head == null) {
            // very first node of the List, empty list
            head = tail = newNode;
            newNode.next = null;
            return;
        }

        // appending new nodes in existing list
        tail.next = newNode; // link
        newNode.next = null; // last node of list
        tail = newNode; // update tail

    }

    public void addMid(int index, int data) {
        // adds node in middle of list

        if (head == null) {
            // if list is fresh new
            System.out.println("List is empty");
            return;
        }

        Node currentNode = head;
        Node newNode = new Node(data);
        size++;

        for (int i = 0; i < index - 1; i++) {
            // traversing temp node to node - 1 position (previous of node)
            currentNode = currentNode.next;
        }

        newNode.next = currentNode.next; // forward link
        currentNode.next = newNode; // backward link

    }

    public void print() {
        // prints all node data

        Node currentNode = head; // temp node to traverse from head to tail

        while (currentNode != null) {
            System.out.print(currentNode.data + " -> "); // print data
            currentNode = currentNode.next; // self update to next node
        }
        System.out.println("null");
    }

    public int delFirst() {

        if (head == null) {
            // no nodes are available
            System.out.println("List is Empty");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            // incase of only on node
            int deletedVal = head.data;
            head = tail = null;
            size--;
            return deletedVal;
        }

        // remaining cases, we shifing head to 2nd node,
        // garbage collector takes care of deleted node
        int deletedVal = head.data;
        head = head.next; // update head
        size--;
        return deletedVal;
    }

    public int delLast() {
        // deletion of last node
        if (head == null) {
            // no nodes are available
            System.out.println("List is Empty");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            // incase of only on node
            int deletedVal = head.data;
            head = tail = null;
            size--;
            return deletedVal;
        }

        // remaining cases
        // garbage collector takes care of deleted node
        Node tempNode = head;
        int deletedVal = tail.data;

        // traversing to 2nd last element as a tempnode
        for (int i = 0; i < size - 2; i++) {
            tempNode = tempNode.next;
        }

        tempNode.next = null; // clears next link
        tail = tempNode; // update tail
        size--;
        return deletedVal;
    }

    public int searchListIterative(int key) {
        // linear search on Linked List

        if (head == null) { // no nodes available
            System.out.println("List is Empty");
            return -1;

        }

        Node tempNode = head;
        for (int i = 0; tempNode != null; i++) {
            if (tempNode.data == key) {
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    public int recursiveSearchHelper(Node currHead, int key) {

        // helper function for recursive list search, does all work

        if (currHead == null) { // base case
            return -1;
        }

        if (currHead.data == key) {
            // first it checks the head, then calls the recursive f(x) for rest of the list
            // for each and every instance of list in this recursive fn, the position of
            // their heads according to them will be always 0.
            return 0;
        }

        int index = recursiveSearchHelper(currHead.next, key); // call for remaining LL
        if (index == -1) {
            // element not found, base case hit
            return -1;
        }

        return index + 1;
        // because each and every instance of the list in recursion has head on 0th
        // position,
        // we'll increase +1 after every backtrack if element is found
    }

    public int searchListRecursive(int key) {
        return recursiveSearchHelper(head, key);
    }

    public void reverseList() { // O(n)

        Node currNode = tail = head; // the head becomes tail after reverse
        Node prevNode = null; // at the beginning, the prevNode is null, because its successor must point to
                              // null
        Node nextNode;

        while (currNode != null) {
            nextNode = currNode.next; // nextNode is the node after currNode
            currNode.next = prevNode; // step to reverse the link, to previous direction
            prevNode = currNode; // prev node moves forward to currNode
            currNode = nextNode; // currNode moves forward to nextNode
        }

        head = prevNode;
        // at last declare prevNode as head, because on the last iteration, the currNode
        // becomes null,
        // the prevNode is actually the last node to operate on, so after reversing,
        // it must be head
    }

    public int deleteNthFromEnd(int nth) {
        // delete nth node from the end (tail)

        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;

        } else if (nth == size) {
            int deletedVal = head.data;
            head = head.next;
            return deletedVal;
        }

        int index = size - nth;
        Node prevNode = head; // traverses to predecessor of deleting node
        Node actNode = head.next; // retrieves the value from deleting node

        for (int i = 1; i < index; i++) {
            prevNode = prevNode.next;
            actNode = actNode.next;
        }

        int deletedVal = actNode.data;
        prevNode.next = actNode.next;
        actNode = null;
        return deletedVal;

    }

    public Node findMidNode(Node head) {
        // finds the mid Node

        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next; // + 1, reaches mid node
            fastNode = fastNode.next.next; // + 2, reaches end, tail
        }
        return slowNode;
    }

    public boolean checkPalindrome() {

        if (head == null || head.next == null) {
            // list has either 0 or 1 node
            return true;
        }

        // step 1 : find mid
        Node midNode = findMidNode(head);

        // step 2 : reverse the second half of list, starting from midNode
        Node prevNode = null;
        Node currNode = midNode; // reverses from mid
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        Node rightNode = prevNode;
        Node leftNode = head;

        // step 3 : check if left half == right half
        while (rightNode != null) {
            if (rightNode.data != leftNode.data) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return true;
    }

    public boolean isCycle() {
        // using floyd cycle finding algorithm, with slow fast approach

        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) { // if list is linear
            slowNode = slowNode.next; // + 1
            fastNode = fastNode.next.next; // + 2

            if (fastNode == slowNode) { // cycle exists
                // when fast approach cycles and returns on same as slow node, hence distance
                // between them is equals to x times D, where x is number of cycles traversed,
                // and D is the length of cycle node.
                return true;
            }
        }

        return false; // cycle doesnt exists
    }

    public void removeCycle() {
        // using floyd cycle finding algorithm, with slow fast approach

        Node slowNode = head;
        Node fastNode = head;
        boolean cycleFlag = false;

        // step 1 : detect cycle
        while (fastNode != null && fastNode.next != null) { // if list is linear
            slowNode = slowNode.next; // + 1
            fastNode = fastNode.next.next; // + 2

            if (fastNode == slowNode) { // cycle exists
                cycleFlag = true;
                break;
            }
        }

        if (!cycleFlag) {
            return;
        }

        // step 2: find meeting point
        slowNode = head;
        // Node prevNode = null;
        while (slowNode != fastNode) {
            if (slowNode.next == fastNode.next) {
                fastNode.next = null; // step 3 : remove cycle
                return;
            }
            // update pointers
            // prevNode = fastNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        // prevNode.next = null; // remove cycle
    }

    private Node getMid(Node listHead) {
        // gets the midNode, as in the last node of the left part of linked list.
        Node slow = listHead;
        Node fast = listHead.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node mergeList(Node leftHead, Node rightHead) {
        Node mergedList = new Node(-1); // temp list, to append sorted nodes to, later removed
        Node mergePtr = mergedList;     // traverses on the temp list

        // compares left and right data, and appends them to mergedList
        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                // left data is smaller
                mergePtr.next = leftHead;
                leftHead = leftHead.next;
                mergePtr = mergePtr.next;
            } else {
                // right data is smaller
                mergePtr.next = rightHead;
                rightHead = rightHead.next;
                mergePtr = mergePtr.next;
            }
        }

        // appending remaining data
        // remaining in left list
        while (leftHead != null) {
            mergePtr.next = leftHead;
            leftHead = leftHead.next;
            mergePtr = mergePtr.next;
        }

        // remaining in right list
        while (rightHead != null) {
            mergePtr.next = rightHead;
            rightHead = rightHead.next;
            mergePtr = mergePtr.next;
        }

        // returning head of the current mergedList, made from 2 smaller linked lists
        return mergedList.next;
    }

    public Node mergeSort(Node listHead) {
        // base case, when atleast
        if (listHead == null || listHead.next == null) {
            return listHead;
        }

        // step 1 : mid node
        Node midNode = getMid(listHead);

        // step 2 : break into 2 parts
        Node rightHead = midNode.next; // first node of right list
        midNode.next = null; // breaking list into 2 halves, one pointed by listHead, and other by rightHead

        Node newLeft = mergeSort(listHead);
        Node newRight = mergeSort(rightHead);
        // recieves the left and right heads of smaller instances of list 
        // to merge them into bigger list

        // step 3 : merge the 2 broken list in one, sorted
        return mergeList(newLeft, newRight);
    }

    public void sort() {
        // globally updating head;
        head = mergeSort(head);
    }

    public void zigZagList() {
        // turn LL in zigzag list
        // step 1 : find mid

        Node midNode = getMid(head);

        // step 2 : reverse 2nd half LL
        Node currNode = midNode.next;
        midNode.next = null; // break link list using midnode
        Node prevNode = null;

        while (currNode != null) {  // reverse the half lisst (after mid)
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        Node leftHead = head;
        Node rightHead = prevNode;
        Node nextLeft, nextRight;

        // step 3 : alternate merge
        while (leftHead != null && rightHead != null) {
            // do the zigzag merge
            nextLeft = leftHead.next;
            nextRight = rightHead.next;
            leftHead.next = rightHead;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        } 
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        // list.addLast(26);
        list.print();
        list.zigZagList();
        list.print();
    }
}
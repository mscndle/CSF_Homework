/**
 * Name:    Mandeep Condle
 * Date:    1/8/14
 * Project: Lesson07
 */

public class IntLinkedList {
    private IntListNode firstNode;

    // IntLinkedList stores a list of unique integers
    public IntLinkedList() {
    }

    public void insert(int value) {
        // TODO: Add the integer, or take no action if it's already in the list
        // TIME COMPLEXITY: O(1)
        if (!contains(value)) {
            if (firstNode == null) {
                IntListNode newNode = new IntListNode(value);
                firstNode = newNode;
            } else {
                IntListNode newNode = new IntListNode(value);
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
        }
    }

    public boolean contains(int value) {
        // TODO: Print out if the linked list contains the given integer
        // TIME COMPLEXITY: O(n)
        IntListNode node = firstNode;
        while (node != null) {
            if (node.getValue() == value) {
                return true;
            } else {
                node = node.getNextNode();
            }
        }
        return false;
    }

    public void remove(int value) {
        // TODO: Remove the given integer from the list, or take no action if it's not in the list
        // TIME COMPLEXITY: O(n)
        IntListNode node = firstNode;
        IntListNode prev = null;

        if (this.contains(value)) {
            while (node != null) {
                if (node.getValue() == value) {
                    if (prev != null) {
                        prev.setNextNode(node.getNextNode());
                    } else {
                        firstNode = node.getNextNode();
                    }
                    node = null;
                } else {
                    prev = node;
                    node = node.getNextNode();
                }
            }
        }
    }


    public void print() {
        IntListNode node = firstNode;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNextNode();
        }
    }
}


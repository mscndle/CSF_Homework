
public class IntLinkedList {
    private IntListNode firstNode;

    // IntLinkedList stores a list of unique integers
    public IntLinkedList() {
    }

    public void insert(int value) {
        // TOOD: Add the integer, or take no action if it's already in the list
    }

    public boolean contains(int value) {
        // TODO: Print out if the linked list contains the given integer
        return false;
    }

    public void remove(int value) {
        // TODO: Remove the given integer from the list, or take no action if it's not in the list
    }

    public void print() {
        IntListNode node = firstNode;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNextNode();
        }
    }
}

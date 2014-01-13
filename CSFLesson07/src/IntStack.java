/**
 * Name:    Mandeep Condle
 * Date:    1/8/14
 * Project: Lesson07
 */

public class IntStack {
    IntListNode firstNode;

    public IntStack() {
    }

    public void push(int value) {
        // TODO: Add a value to the top of the stack
        // TIME COMPLEXITY: O(1)
        if (firstNode == null) {
            IntListNode newNode = new IntListNode(value);
            firstNode = newNode;
        } else {
            IntListNode newNode = new IntListNode(value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
    }

    public int pop() {
        // TODO: Pop the first value off the stack
        // TIME COMPLEXITY: O(1)
        if (this.size() != 0) {
            IntListNode tempNode = firstNode;
            int tempVal = tempNode.getValue();

            firstNode = firstNode.getNextNode();
            tempNode = null;
            return tempVal;
        } else {
            return -1;
        }
    }

    public int size() {
        // TIME COMPLEXITY: O(n)
        int size = 0;

        IntListNode node = firstNode;
        while (node != null) {
            size++;
            node = node.getNextNode();
        }
        return size;
    }
}

/**
 * Name:    Mandeep Condle
 * Date:    1/8/14
 * Project: Lesson07
 */

public class IntListNode {
    private int value;
    private IntListNode nextNode;

    public IntListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public IntListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(IntListNode nextNode) {
        this.nextNode = nextNode;
    }
}

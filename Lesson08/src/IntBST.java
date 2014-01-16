import java.util.LinkedList;


public class IntBST {
    private IntNode rootNode;

    public String bfsRepresentation() {
        // TODO: Return a string representation of a breadth-first search of this tree.
        // Nodes are space-delimited, e.g. "1 2 4 5"
        // Hint: Use a queue and, starting with the root node, then enqueue its left and right children.
        // Hint: The StringBuilder class is useful for constructing strings that are constantly appended to

        // Sample solution, remove prior to class
        StringBuilder stringBuilder = new StringBuilder();

        LinkedList<IntNode> queue = new LinkedList<IntNode>();
        if (rootNode != null) {
            queue.add(rootNode);
        }

        while(!queue.isEmpty()) {
            IntNode node = queue.remove();
            stringBuilder.append(node.getValue() + " ");

            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        return stringBuilder.toString().trim();
    }

    public void insertValue(int value) {
        // TODO: Insert a value into the tree, maintaining the 'binary' property of the tree.

        // Sample soln, remove prior to class

        if (rootNode == null) {
            rootNode = new IntNode(value);
        }
        else {
            IntNode currentNode = rootNode;

            while (currentNode.getValue() != value) {
                if (value > currentNode.getValue()) { // Right child path
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new IntNode(value));
                    }
                    currentNode = currentNode.getRightChild();
                }
                else { // Left child path
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(new IntNode(value));
                    }
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
    }

    public boolean search(int value) {
        // TODO: Return whether the tree contains a given value

        // Sample soln, remove prior to class
        IntNode currentNode = rootNode;

        while(currentNode != null && (currentNode.getValue() != value)) {
            if (value > currentNode.getValue()) { // Continue down the right child path
                currentNode = currentNode.getRightChild();
            }
            else { // Continue down the left child path
                currentNode = currentNode.getLeftChild();
            }
        }
        // If the current node exists and its value is equal to the input, return true, else return false
        return currentNode != null && (currentNode.getValue() == value);
    }
}

/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class BinaryNode<T extends Comparable<? super T>> {

    private T data;

    private BinaryNode<T> leftChild;

    private BinaryNode<T> rightChild;

	
    public BinaryNode() {
	this(null, null, null);
    }

    public BinaryNode(T newData) {
	this(newData, null, null);
    }

    public BinaryNode(T newData, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
	data = newData;
	this.leftChild = leftChild;
	this.rightChild = rightChild;
    }
	
    public T getData() {
	return data;
    }

    public void setData(T newData) {
	data = newData;
    }

    public BinaryNode<T> getLeftChild() {
	return leftChild;
    }

    public BinaryNode<T> getRightChild() {
	return rightChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
	this.leftChild = leftChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
	this.rightChild = rightChild;
    }

    public boolean hasLeftChild() {
	return leftChild != null;
    }

    public boolean hasRightChild() {
	return rightChild != null;
    }
	
    public int getHeight() {
	//CN initialize counters for both nodes
	int leftHeight = 0;
	int rightHeight = 0;
	//CN if there is a left node, get height add it and 1 to the running total
	if(hasLeftChild()) leftHeight += 1 + getLeftChild().getHeight();
	//CN if there is a right node, get height add it and 1 to the running total
	if(hasRightChild())	rightHeight += 1 + getRightChild().getHeight();
	//CN return the larger counter
	return Math.max(leftHeight, rightHeight);
    }

    public int getNumberOfNodes() {
	int total = 1;
	//CN get the number of nodes for the left node if not null
	if (leftChild != null) total += leftChild.getNumberOfNodes();
	//CN get the number of nodes for the right node if not null
	if (rightChild != null)	total += rightChild.getNumberOfNodes();
	return total;
    }
	
    public boolean isLeaf() {
	if (leftChild == null && rightChild == null) return true;
	return false;
    }

    public BinaryNode<T> copy() {
	BinaryNode<T> newNode = new BinaryNode<T> (data, leftChild, rightChild);
	return newNode;
    }
}
